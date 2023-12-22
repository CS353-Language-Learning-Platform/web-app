package com.example.backend.services;

import com.example.backend.repositories.TargetLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TargetLanguageService {
    @Autowired
    private TargetLanguageRepository targetLanguageRepository;

    public Long countLearnersForLanguage(long languageId) {
        return targetLanguageRepository.getTargetLanguageLearnerCount(languageId);
    }
}