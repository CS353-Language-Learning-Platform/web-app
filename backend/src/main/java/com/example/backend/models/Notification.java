package com.example.backend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {

    private Integer notificationId;
    private String title;
    private String description;
    private Long userId;
}
