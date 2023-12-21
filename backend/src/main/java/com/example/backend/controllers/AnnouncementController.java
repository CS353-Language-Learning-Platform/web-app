package com.example.backend.controllers;

import com.example.backend.models.Announcement;
import com.example.backend.requests.AnnouncementAddRequest;
import com.example.backend.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/teacher/{teacherId}")
    public List<Announcement> getAnnouncementsByTeacherId(@PathVariable Long teacherId) {
        return announcementService.getAnnouncementsByTeacherId(teacherId);
    }

    @PostMapping
    public void addAnnouncement(@RequestBody AnnouncementAddRequest request) {
        announcementService.addAnnouncement(request);
    }
}
