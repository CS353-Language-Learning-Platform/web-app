package com.example.backend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Appointment {

    private Long senderId;
    private Long receiverId;
    private String message;
    private Date startTime;
    private Date endDate;
    private Boolean isApproved;
    private Integer senderRating;
    private Integer receiverRating;
}
