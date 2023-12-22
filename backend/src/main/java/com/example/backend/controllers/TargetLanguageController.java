package com.example.backend.controllers;

import com.example.backend.services.TargetLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/languages")
public class TargetLanguageController {
    @Autowired
    private TargetLanguageService targetLanguageService;

    @GetMapping("/{languageId}/learner-count")
    public ResponseEntity<Long> getLearnerCountForLanguage(@PathVariable Long languageId) {
        long count = targetLanguageService.countLearnersForLanguage(languageId);
        return ResponseEntity.ok(count);
    }
}