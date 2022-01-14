package com.dealership.serviceusers.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public final class User {
    @Column(name = "user_type")
    private String userType;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
}
