package com.example.backend.services;

import com.example.backend.dto.LearnerInfoDTO;
import com.example.backend.models.LanguageLearner;
import com.example.backend.repositories.LanguageLearnerRepository;
import com.example.backend.repositories.UserRepository;
import com.example.backend.requests.LanguageLearnerAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LanguageLearnerService {

    private final LanguageLearnerRepository languageLearnerRepository;
    private final UserRepository userRepository;

    @Autowired
    public LanguageLearnerService(LanguageLearnerRepository languageLearnerRepository, UserRepository userRepository) {
        this.languageLearnerRepository = languageLearnerRepository;
        this.userRepository = userRepository;
    }

    public LanguageLearner getLearnerById(Long userId) {
        return languageLearnerRepository.getLearnerById(userId);
    }

    @Transactional
    public void addLearner(LanguageLearnerAddRequest request) {
        if (request.getUserId() == null || !userRepository.existsById(request.getUserId())) {
            throw new RuntimeException("User id is null or user does not exist while adding a language learner");
        }

        LanguageLearner learner = new LanguageLearner();
        learner.setUserId(request.getUserId());
        languageLearnerRepository.addLearner(learner);
    }

    public List<LearnerInfoDTO> getAllLearners() {
        return languageLearnerRepository.getAllLearners();
    }
}
