package com.example.backend.services;

import com.example.backend.models.Notification;
import com.example.backend.repositories.LanguageLearnerRepository;
import com.example.backend.repositories.NotificationRepository;
import com.example.backend.repositories.UserRepository;
import com.example.backend.requests.NotificationAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Autowired
    public NotificationService( NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    public List<Notification> getAllNotificationsByUserId(Long userId) {
        return notificationRepository.getAllNotificationsByUserId(userId);
    }

    public Notification getNotificationById(Integer notificationId) {
        return notificationRepository.getNotificationById(notificationId);
    }

    public void addNotification(NotificationAddRequest request) {
        // check if title is empty
        if (request.getTitle().isEmpty()) {
            throw new IllegalStateException("Title cannot be empty");
        }
        // check if description is empty
        if (request.getDescription().isEmpty()) {
            throw new IllegalStateException("Description cannot be empty");
        }
        // check if userId is empty
        if (request.getUserId() == null) {
            throw new IllegalStateException("User id cannot be empty");
        }
        // check if userId exists
        if (!userRepository.existsById(request.getUserId())) {
            throw new IllegalStateException("User with id " + request.getUserId() + " does not exist");
        }

        Notification notification = new Notification();
        notification.setTitle(request.getTitle());
        notification.setDescription(request.getDescription());
        notification.setUserId(request.getUserId());
        notificationRepository.addNotification(notification);

    }

}
