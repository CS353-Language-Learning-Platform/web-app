package com.example.backend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Teacher {
    private Long userId;
    private Float sessionPricePerHour;
    private Boolean isApproved;
    private Date requestDate;
    private Date responseDate;
    private Long activationAdminId;
}
