package com.example.backend.requests;

import lombok.Getter;

import java.util.Date;

@Getter
public class AppointmentAddRequest {

    private Long senderId;
    private Long receiverId;
    private String message;
    private Date startTime;
    private Date endDate;
    private Boolean isApproved;
    private Integer senderRating;
    private Integer receiverRating;
}
