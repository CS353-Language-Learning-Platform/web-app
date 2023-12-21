package com.example.backend.repositories;

import com.example.backend.models.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnnouncementRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AnnouncementRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Announcement> getAnnouncementsByTeacherId(Long teacherId) {
        String sql = "SELECT * FROM announcement WHERE teacher_id = ?";
        return jdbcTemplate.query(sql, new Object[]{teacherId}, (rs, rowNum) -> {
            Announcement announcement = new Announcement();
            announcement.setAnnouncementId(rs.getInt("a_id"));
            announcement.setTitle(rs.getString("title"));
            announcement.setContent(rs.getString("content"));
            announcement.setTeacherId(rs.getLong("teacher_id"));
            return announcement;
        });
    }


    public void addAnnouncement(Announcement announcement) {
        String sql = "INSERT INTO announcement (title, content, teacher_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, announcement.getTitle(), announcement.getContent(), announcement.getTeacherId());
    }
}
