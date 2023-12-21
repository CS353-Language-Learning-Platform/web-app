package com.example.backend.requests;

import lombok.Getter;

@Getter
public class AnnouncementAddRequest {

    private String title;
    private String content;
    private Long teacherId;
}
