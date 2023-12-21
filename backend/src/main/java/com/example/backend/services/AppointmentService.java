package com.example.backend.services;

import com.example.backend.models.Appointment;
import com.example.backend.repositories.AppointmentRepository;
import com.example.backend.repositories.UserRepository;
import com.example.backend.requests.AppointmentAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    public List<Appointment> getAppointmentsBySenderId(Long senderId) {
        return appointmentRepository.getAppointmentsBySenderId(senderId);
    }

    public List<Appointment> getAppointmentsByReceiverId(Long receiverId) {
        return appointmentRepository.getAppointmentsByReceiverId(receiverId);
    }

    public void addAppointment(AppointmentAddRequest appointmentAddRequest) {
        // check if sender and receiver and start time is not null
        if (appointmentAddRequest.getSenderId() == null) {
            throw new IllegalStateException("Sender id is null");
        }
        if (appointmentAddRequest.getReceiverId() == null) {
            throw new IllegalStateException("Receiver id is null");
        }
        if (appointmentAddRequest.getStartTime() == null) {
            throw new IllegalStateException("Start time is null");
        }
        if (userRepository.existsById(appointmentAddRequest.getSenderId()) == false) {
            throw new IllegalStateException("Sender does not exist");
        }
        if (userRepository.existsById(appointmentAddRequest.getReceiverId()) == false) {
            throw new IllegalStateException("Receiver does not exist");
        }

        Appointment appointment = new Appointment();
        appointment.setSenderId(appointmentAddRequest.getSenderId());
        appointment.setReceiverId(appointmentAddRequest.getReceiverId());
        appointment.setMessage(appointmentAddRequest.getMessage());
        appointment.setStartTime(appointmentAddRequest.getStartTime());
        appointment.setEndDate(appointmentAddRequest.getEndDate());
        appointment.setIsApproved(appointmentAddRequest.getIsApproved());
        appointment.setSenderRating(appointmentAddRequest.getSenderRating());
        appointment.setReceiverRating(appointmentAddRequest.getReceiverRating());

        appointmentRepository.addAppointment(appointment);

    }

}
