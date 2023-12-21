package com.example.backend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Announcement {

    private Integer announcementId;
    private String title;
    private String content;
    private Long teacherId;
}
