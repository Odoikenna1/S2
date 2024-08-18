package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.domain.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogOutRequest {
    private String userId;
    private boolean isLoggedIn;
}
