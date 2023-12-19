package com.example.backend.repositories;

import com.example.backend.models.Teacher;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TeacherRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TeacherRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Teacher getTeacherById(Long userId) {
        String sql = "SELECT user_id FROM teacher WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, teacherRowMapper());
    }

    public List<Teacher> getAllTeachers() {
        String sql = "SELECT user_id FROM teacher";
        return jdbcTemplate.query(sql, teacherRowMapper());
    }

    private RowMapper<Teacher> teacherRowMapper() {
        return (rs, rowNum) -> {
            Teacher teacher = new Teacher();
            teacher.setUserId(rs.getLong("user_id"));
            return teacher;
        };
    }

    public void addTeacher(Teacher teacher) {
        String sql = "INSERT INTO teacher (user_id, session_price_per_hour, is_approved, request_date, response_date, activation_admin_id) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, teacher.getUserId(), teacher.getSessionPricePerHour(), teacher.getIsApproved(), teacher.getRequestDate(), teacher.getResponseDate(), teacher.getActivationAdminId());
    }



}
