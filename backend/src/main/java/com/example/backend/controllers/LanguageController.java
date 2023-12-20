package com.example.backend.controllers;

import com.example.backend.dto.TargetLanguageInfoDTO;
import com.example.backend.models.Language;
import com.example.backend.requests.LanguageAddRequest;
import com.example.backend.requests.TargetLanguageAddRequest;
import com.example.backend.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/{languageId}")
    public Language getLanguageById(@PathVariable Long languageId) {
        return languageService.getLanguageById(languageId);
    }

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @PostMapping
    public void addLanguage(@RequestBody LanguageAddRequest request) {
        languageService.addLanguage(request);
    }

    @GetMapping("/target/{userId}")
    public List<TargetLanguageInfoDTO> getAllTargetLanguagesByUserId(@PathVariable Long userId) {
        return languageService.getAllTargetLanguagesByUserId(userId);
    }

    @PostMapping("/target")
    public void addTargetLanguage(@RequestBody TargetLanguageAddRequest request) {
        languageService.addTargetLanguage(request);
    }


}
