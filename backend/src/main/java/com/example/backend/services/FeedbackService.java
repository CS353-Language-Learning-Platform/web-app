package com.example.backend.services;


import com.example.backend.models.Feedback;
import com.example.backend.repositories.FeedbackRepository;
import com.example.backend.requests.FeedbackAddRequest;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback getFeedbackById(Integer feedbackId) {
        return feedbackRepository.getFeedbackById(feedbackId);
    }

    public void addFeedback(FeedbackAddRequest request) {
//        if (request == null) {
//            throw new RuntimeException("Feedback request is null");
//        }
//        if (request.getTitle() == null || request.getContent() == null) {
//            throw new RuntimeException("Feedback title or content is null");
//        }
//        // check if title or content is empty
//        if (request.getTitle().trim().isEmpty() || request.getContent().trim().isEmpty()) {
//            throw new RuntimeException("Feedback title or content is empty");
//        }
//
//        Feedback feedback = new Feedback();
//        feedback.setTitle(request.getTitle());
//        feedback.setContent(request.getContent());

        feedbackRepository.addFeedback(request);
    }
}
