package com.semicolon.africa.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class RegisterResponse {
    private String firstName;
    private String message;
    private String userId;
    private String address;
}
