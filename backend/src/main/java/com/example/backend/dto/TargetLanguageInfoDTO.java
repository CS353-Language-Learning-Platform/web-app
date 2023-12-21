package com.example.backend.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TargetLanguageInfoDTO {
    private Integer languageId;
    private Integer learnerId;
    private String proficiencyLevel;
}
