package com.example.backend.repositories;


import com.example.backend.models.Feedback;
import com.example.backend.requests.FeedbackAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedbackRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FeedbackRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Feedback getFeedbackById(Integer feedbackId) {
        String sql = "SELECT f_id, title, content FROM feedback WHERE f_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{feedbackId}, feedbackRowMapper());
    }

    private RowMapper<Feedback> feedbackRowMapper() {
        return (rs, rowNum) -> {
            Feedback feedback = new Feedback();
            feedback.setFeedbackId(rs.getInt("f_id"));
            feedback.setTitle(rs.getString("title"));
            feedback.setContent(rs.getString("content"));
            return feedback;
        };
    }

    public void addFeedback(FeedbackAddRequest request) {
            String sql = "INSERT INTO feedback (title, content) VALUES (?, ?)";
            jdbcTemplate.update(sql, request.getTitle(), request.getContent());
    }


}
