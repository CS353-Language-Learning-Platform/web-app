package com.example.backend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private Long userId;
    private String name;
    private String email;
    private String biography;
    private String nationality;
    private Date birthDate;
    private String password;
    private Date suspenseDate;
}