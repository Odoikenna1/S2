package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.Gender;
import com.semicolon.africa.data.domain.Role;
import com.semicolon.africa.data.domain.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserAuthenticationRequest {
    private String firstName;
    private String lastName;
    private String brandName;
    private String userName;
    private String dateOfBirth;
    private Gender gender;
    private String address;
    private String emailAddress;
    private String password;
    private String creditCardInfo;
    private Role role;
    private boolean isActive;
    private SessionStatus sessionStatus;
}
