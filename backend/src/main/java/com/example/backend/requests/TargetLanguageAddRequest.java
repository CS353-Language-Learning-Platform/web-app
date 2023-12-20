package com.example.backend.requests;

import lombok.Getter;

@Getter
public class TargetLanguageAddRequest {

        private Integer languageId;
        private Long learnerId;
        private String proficiencyLevel;
}
