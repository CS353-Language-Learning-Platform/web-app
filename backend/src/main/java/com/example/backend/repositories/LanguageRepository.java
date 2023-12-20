package com.example.backend.repositories;

import com.example.backend.models.Language;
import com.example.backend.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LanguageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Language getLanguageById(Long languageId) {
        String sql = "SELECT language_id, language_name FROM language WHERE language_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{languageId}, languageRowMapper());
    }

    private RowMapper<Language> languageRowMapper() {
        return (rs, rowNum) -> {
            Language language = new Language();
            language.setLanguageId(rs.getInt("language_id"));
            language.setLanguageName(rs.getString("language_name"));
            return language;
        };
    }

    public List<Language> getAllLanguages() {
        String sql = "SELECT language_id, language_name FROM language";
        return jdbcTemplate.query(sql, languageRowMapper());
    }

    public void addLanguage(Language language) {
        String sql = "INSERT INTO language (language_id, language_name) VALUES (?, ?)";
        jdbcTemplate.update(sql, language.getLanguageId(), language.getLanguageName());
    }


}
