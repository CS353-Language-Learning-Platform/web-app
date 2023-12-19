package com.example.backend.controllers;

import com.example.backend.dto.LearnerInfoDTO;
import com.example.backend.models.LanguageLearner;
import com.example.backend.models.User;
import com.example.backend.requests.LanguageLearnerAddRequest;
import com.example.backend.services.LanguageLearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learners")
public class LanguageLearnerController {

    private final LanguageLearnerService languageLearnerService;

    @Autowired
    public LanguageLearnerController(LanguageLearnerService languageLearnerService) {
        this.languageLearnerService = languageLearnerService;
    }

    @GetMapping("/{userId}")
    public LanguageLearner getLearnerById(@PathVariable Long userId) {
        return languageLearnerService.getLearnerById(userId);
    }

    @GetMapping()
    public List<LearnerInfoDTO> getAllLearners() {
        return languageLearnerService.getAllLearners();
    }

    @PostMapping()
    public void addLearner(@RequestBody LanguageLearnerAddRequest request) {
        languageLearnerService.addLearner(request);
    }

}
