package com.example.backend.controllers;

import com.example.backend.models.Feedback;
import com.example.backend.requests.FeedbackAddRequest;
import com.example.backend.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/{feedbackId}")
    public Feedback getFeedbackById(@PathVariable Integer feedbackId) {
        return feedbackService.getFeedbackById(feedbackId);
    }

    @PostMapping()
    public void addFeedback(@RequestBody FeedbackAddRequest request) {
        feedbackService.addFeedback(request);
    }




}
