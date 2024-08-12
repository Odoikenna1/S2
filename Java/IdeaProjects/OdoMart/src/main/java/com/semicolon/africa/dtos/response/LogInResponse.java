package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.domain.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogInResponse {
    private String userId;
    private SessionStatus sessionStatus;
}
