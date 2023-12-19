package com.example.backend.requests;

import lombok.Getter;

import java.util.Date;

@Getter
public class UserAddRequest {

    private Long userId;
    private String name;
    private String email;
    private String biography;
    private String nationality;
    private Date birthDate;
    private String password;
//    private Date suspenseDate;
}
