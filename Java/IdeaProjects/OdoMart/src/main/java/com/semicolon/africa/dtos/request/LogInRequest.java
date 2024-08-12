package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.Role;
import com.semicolon.africa.data.domain.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogInRequest {
    private String userId;
    private String email;
    private String password;
    private String brandName;
    private Role role;
    private SessionStatus sessionStatus;
}
