package com.example.backend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LanguageLearner {
    private Long userId;
    private Date lastSeenTime;

}
