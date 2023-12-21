package com.example.backend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Feedback {

    private Integer feedbackId;
    private String title;
    private String content;
}
