package com.example.backend.requests;

import lombok.Getter;

import java.util.Date;

@Getter
public class TeacherAddRequest {

    private Long userId;
    private Float sessionPricePerHour;
    private Boolean isApproved;
    private Date requestDate;
    private Date responseDate;
    private Long activationAdminId;
}
