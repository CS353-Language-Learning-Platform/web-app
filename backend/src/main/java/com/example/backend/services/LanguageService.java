package com.example.backend.services;


import com.example.backend.models.Language;
import com.example.backend.repositories.LanguageRepository;
import com.example.backend.requests.LanguageAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Language getLanguageById(Long languageId) {
        return languageRepository.getLanguageById(languageId);
    }

    public List<Language> getAllLanguages() {
        return languageRepository.getAllLanguages();
    }

    public void addLanguage(LanguageAddRequest request) {
        if (request == null) {
            throw new RuntimeException("Language request is null while adding a language");
        }
        if (request.getLanguageId() == null) {
            throw new RuntimeException("Language id is null while adding a language");
        }
        if (request.getLanguageName() == null) {
            throw new RuntimeException("Language name is null while adding a language");
        }
        if (request.getLanguageName().trim().isEmpty()) {
            throw new RuntimeException("Language name is empty while adding a language");
        }

        Language language = new Language();
        language.setLanguageId(request.getLanguageId());
        language.setLanguageName(request.getLanguageName());

        languageRepository.addLanguage(language);
    }
}
