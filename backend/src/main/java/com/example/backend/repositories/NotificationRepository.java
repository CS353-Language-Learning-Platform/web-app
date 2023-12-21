package com.example.backend.repositories;

import com.example.backend.models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NotificationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Notification> getAllNotificationsByUserId(Long userId) {
        String sql = "SELECT * FROM notification WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, notificationRowMapper());
    }

    public Notification getNotificationById(Integer notificationId) {
        String sql = "SELECT * FROM notification WHERE n_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{notificationId}, notificationRowMapper());
    }

    // implement row mapper
    private RowMapper<Notification> notificationRowMapper() {
        return (resultSet, i) -> {
            Notification notification = new Notification();
            notification.setNotificationId(resultSet.getInt("n_id"));
            notification.setTitle(resultSet.getString("title"));
            notification.setDescription(resultSet.getString("description"));
            notification.setUserId(resultSet.getLong("user_id"));
            return notification;
        };
    }

    public void addNotification(Notification notification) {
        String sql = "INSERT INTO notification (title, description, user_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, notification.getTitle(), notification.getDescription(), notification.getUserId());
    }




}
