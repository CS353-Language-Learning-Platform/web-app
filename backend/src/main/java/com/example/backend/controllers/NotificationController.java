package com.example.backend.controllers;

import com.example.backend.models.Notification;
import com.example.backend.requests.NotificationAddRequest;
import com.example.backend.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/user/{userId}")
    public List<Notification> getAllNotificationsByUserId(@PathVariable Long userId) {
        return notificationService.getAllNotificationsByUserId(userId);
    }

    @GetMapping("/{notificationId}")
    public Notification getNotificationById(@PathVariable Integer notificationId) {
        return notificationService.getNotificationById(notificationId);
    }

    @PostMapping
    public void addNotification(@RequestBody NotificationAddRequest request) {
        notificationService.addNotification(request);
    }



}
