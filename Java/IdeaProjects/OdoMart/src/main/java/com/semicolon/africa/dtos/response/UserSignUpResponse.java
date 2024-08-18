package com.semicolon.africa.dtos.response;

import com.semicolon.africa.data.domain.SessionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UserSignUpResponse {
    private String firstName;
    private String message;
    private String shoppingCartId;
    private String userId;
    private boolean loggedIn;
}
