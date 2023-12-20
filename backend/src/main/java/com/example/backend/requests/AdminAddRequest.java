package com.example.backend.requests;

import lombok.Getter;

import java.util.Date;

@Getter
public class AdminAddRequest {

    private Long userId;
    private Date startDate;
}
