package com.example.backend.repositories;

import com.example.backend.dto.LearnerInfoDTO;
import com.example.backend.models.LanguageLearner;
import com.example.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LanguageLearnerRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LanguageLearnerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public LanguageLearner getLearnerById(Long userId) {
        String sql = "SELECT user_id FROM language_learner WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, learnerRowMapper());
    }

    @Transactional
    public void addLearner(LanguageLearner learner) {
        String sql = "INSERT INTO language_learner (user_id) VALUES (?)";
        jdbcTemplate.update(sql, learner.getUserId());
    }

//    public List<LanguageLearner> getAllLearners() {
//        String sql = "SELECT user_id, name FROM language_learner, user WHERE language_learner.user_id = user.user_id";
//        return jdbcTemplate.query(sql, learnerRowMapper());
//    }



    public List<LearnerInfoDTO> getAllLearners() {
        String sql = "SELECT language_learner.user_id, user.name FROM language_learner JOIN user ON language_learner.user_id = user.user_id";
        return jdbcTemplate.query(sql, learnerInfoDTORowMapper());
    }

    private RowMapper<LearnerInfoDTO> learnerInfoDTORowMapper() {
        return (rs, rowNum) -> {
            LearnerInfoDTO dto = new LearnerInfoDTO();
            dto.setUserId(rs.getLong("user_id"));
            dto.setName(rs.getString("name"));
            return dto;
        };
    }


    private RowMapper<LanguageLearner> learnerRowMapper() {
        return (rs, rowNum) -> {
            LanguageLearner learner = new LanguageLearner();
            learner.setUserId(rs.getLong("user_id"));

            // Set other fields of User
            return learner;
        };
    }

    public boolean learnerExistsById(Long userId) {
        String sql = "SELECT COUNT(*) FROM language_learner WHERE user_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{userId}, Integer.class);
        return count != null && count > 0;
    }
}
