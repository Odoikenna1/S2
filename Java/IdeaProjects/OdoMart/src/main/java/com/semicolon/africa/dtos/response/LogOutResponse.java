package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.domain.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogOutResponse {
    private boolean loggedIn = false;
}
