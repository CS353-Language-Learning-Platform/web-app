package com.example.backend.repositories;

import com.example.backend.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Admin getAdminById(Long userId) {
        String sql = "SELECT user_id, start_date FROM admin WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, adminRowMapper());
    }

    private RowMapper<Admin> adminRowMapper() {
        return (rs, rowNum) -> {
            Admin admin = new Admin();
            admin.setUserId(rs.getLong("user_id"));
            admin.setStartDate(rs.getDate("start_date"));
            return admin;
        };
    }

    public List<Admin> getAllAdmins() {
        String sql = "SELECT user_id FROM admin";
        return jdbcTemplate.query(sql, adminRowMapper());
    }

    public void addAdmin(Admin admin) {

        String sql = "INSERT INTO admin (user_id, start_date) VALUES (?, ?)";
        jdbcTemplate.update(sql, admin.getUserId(), admin.getStartDate());
    }
}
