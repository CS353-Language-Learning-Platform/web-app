package com.example.backend.services;

import com.example.backend.models.Announcement;
import com.example.backend.repositories.AnnouncementRepository;
import com.example.backend.repositories.UserRepository;
import com.example.backend.requests.AnnouncementAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;

    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository, UserRepository userRepository) {
        this.announcementRepository = announcementRepository;
        this.userRepository = userRepository;
    }

    public List<Announcement> getAnnouncementsByTeacherId(Long teacherId) {
        return announcementRepository.getAnnouncementsByTeacherId(teacherId);
    }

    public void addAnnouncement(AnnouncementAddRequest request) {
        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            System.out.println(request.getTitle() );
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (request.getContent() == null || request.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Content cannot be empty");
        }
        // check if user exists
        if ( !userRepository.existsById(request.getTeacherId())) {
            throw new IllegalArgumentException("User does not exist");
        }

        Announcement announcement = new Announcement();
        announcement.setTitle(request.getTitle());
        announcement.setContent(request.getContent());
        announcement.setTeacherId(request.getTeacherId());

        announcementRepository.addAnnouncement(announcement);

    }

}
