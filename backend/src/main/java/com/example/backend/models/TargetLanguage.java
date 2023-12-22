package com.example.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TargetLanguages")
@Getter
@Setter
public class TargetLanguage {
    @Id
    private Long learnerId;
    private Long languageId;
    private String proficiencyLevel;
}
