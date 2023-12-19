package com.example.backend.requests;

import lombok.Getter;

import java.util.Date;

@Getter
public class LanguageLearnerAddRequest {
    private Long userId;
    private Date lastSeenTime;
}
