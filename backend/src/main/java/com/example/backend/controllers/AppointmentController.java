package com.example.backend.controllers;

import com.example.backend.models.Appointment;
import com.example.backend.requests.AppointmentAddRequest;
import com.example.backend.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/sender/{senderId}")
    public List<Appointment> getAppointmentsBySenderId(@PathVariable Long senderId) {
        return appointmentService.getAppointmentsBySenderId(senderId);
    }

    @GetMapping("/receiver/{receiverId}")
    public List<Appointment> getAppointmentsByReceiverId(@PathVariable Long receiverId) {
        return appointmentService.getAppointmentsByReceiverId(receiverId);
    }

    @PostMapping
    public void addAppointment(@RequestBody AppointmentAddRequest request) {
        appointmentService.addAppointment(request);
    }


}
