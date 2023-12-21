package com.example.backend.requests;

import lombok.Getter;

@Getter
public class NotificationAddRequest {

    private String title;
    private String description;
    private Long userId;
}
