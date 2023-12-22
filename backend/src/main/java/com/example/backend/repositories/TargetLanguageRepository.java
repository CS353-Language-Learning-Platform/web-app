package com.example.backend.repositories;

import com.example.backend.models.TargetLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TargetLanguageRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TargetLanguageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long getTargetLanguageLearnerCount(long languageId) {
        String sql = "SELECT COUNT(DISTINCT tl.learnerId) FROM TargetLanguage tl WHERE tl.languageId = :languageId";

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("languageId", languageId);

        Long count = namedParameterJdbcTemplate.queryForObject(sql, parameters, Long.class);
        return (count != null) ? count : 0;
    }

}