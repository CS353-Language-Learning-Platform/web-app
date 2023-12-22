package com.example.backend.repositories;

import com.example.backend.dto.TargetLanguageInfoDTO;
import com.example.backend.models.Language;
import com.example.backend.requests.TargetLanguageAddRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageRepository {

    private final JdbcTemplate jdbcTemplate;

    private final LanguageLearnerRepository languageLearnerRepository;

    @Autowired
    public LanguageRepository(JdbcTemplate jdbcTemplate, LanguageLearnerRepository languageLearnerRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.languageLearnerRepository = languageLearnerRepository;
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

    public List<TargetLanguageInfoDTO> getAllTargetLanguagesByUserId(Long userId) {
        String sql = "SELECT language.language_id, language.language_name, target_language.proficiency_level FROM language JOIN target_language ON target_language.language_id = language.language_id WHERE target_language.learner_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            TargetLanguageInfoDTO targetLanguageInfoDTO = new TargetLanguageInfoDTO();
            targetLanguageInfoDTO.setLanguageId(rs.getInt("language_id"));
            targetLanguageInfoDTO.setLearnerId(rs.getInt("learner_id"));
            targetLanguageInfoDTO.setProficiencyLevel(rs.getString("proficiency_level"));
            return targetLanguageInfoDTO;
        });
    }

    public void addTargetLanguage(TargetLanguageAddRequest request) {
        if (request.getLearnerId() == null || request.getLanguageId() == null || request.getProficiencyLevel() == null) {
            throw new RuntimeException("Learner id, language id and proficiency level must be provided");
        }
        if (!languageLearnerRepository.learnerExistsById(request.getLearnerId())) {
            throw new RuntimeException("Learner does not exist");
        }
        if (!languageExistsById(request.getLanguageId())) {
            throw new RuntimeException("Language does not exist");
        }
        if (targetLanguageExistsById(request.getLanguageId(), request.getLearnerId())) {
            throw new RuntimeException("Target language already exists for user with id" + request.getLearnerId());
        }

        String sql = "INSERT INTO target_language (learner_id, language_id, proficiency_level) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, request.getLearnerId(), request.getLanguageId(), request.getProficiencyLevel());
    }

    public boolean languageExistsById(Integer languageId) {
        String sql = "SELECT COUNT(*) FROM language WHERE language_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{languageId}, Integer.class);
        return count != null && count > 0;
    }

    public boolean targetLanguageExistsById(Integer languageId, Long learnerId) {
        String sql = "SELECT COUNT(*) FROM target_language WHERE language_id = ? AND learner_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{languageId, learnerId}, Integer.class);
        return count != null && count > 0;
    }

}
