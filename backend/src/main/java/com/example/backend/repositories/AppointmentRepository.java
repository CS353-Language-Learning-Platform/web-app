package com.example.backend.repositories;

import com.example.backend.models.Appointment;
import com.example.backend.models.User;
import com.example.backend.requests.AppointmentAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AppointmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Appointment> getAppointmentsBySenderId(Long senderId) {
        String sql = "SELECT sender_id, receiver_id, message, start_time, end_date, is_approved, sender_rating, receiver_rating FROM appointment WHERE sender_id = ?";
        return jdbcTemplate.query(sql, new Object[]{senderId}, appointmentRowMapper());
    }

    public List<Appointment> getAppointmentsByReceiverId(Long receiverId) {
        String sql = "SELECT sender_id, receiver_id, message, start_time, end_date, is_approved, sender_rating, receiver_rating FROM appointment WHERE receiver_id = ?";
        return jdbcTemplate.query(sql, new Object[]{receiverId}, appointmentRowMapper());
    }

    private RowMapper<Appointment> appointmentRowMapper() {
        return (resultSet, i) -> {
            Appointment appointment = new Appointment();
            appointment.setSenderId(resultSet.getLong("sender_id"));
            appointment.setReceiverId(resultSet.getLong("receiver_id"));
            appointment.setMessage(resultSet.getString("message"));
            appointment.setStartTime(resultSet.getDate("start_time"));
            appointment.setEndDate(resultSet.getDate("end_date"));
            appointment.setIsApproved(resultSet.getBoolean("is_approved"));
            appointment.setSenderRating(resultSet.getInt("sender_rating"));
            appointment.setReceiverRating(resultSet.getInt("receiver_rating"));
            return appointment;
        };
    }

    public void addAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointment (sender_id, receiver_id, message, start_time, end_date, is_approved, sender_rating, receiver_rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, appointment.getSenderId(), appointment.getReceiverId(), appointment.getMessage(), appointment.getStartTime(), appointment.getEndDate(), appointment.getIsApproved(), appointment.getSenderRating(), appointment.getReceiverRating());
    }


}
