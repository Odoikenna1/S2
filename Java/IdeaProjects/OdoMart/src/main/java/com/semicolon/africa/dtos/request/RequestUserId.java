package com.semicolon.africa.dtos.request;

import com.semicolon.africa.data.models.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestUserId {
    private User user;
}
