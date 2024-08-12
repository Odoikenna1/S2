package com.semicolon.africa.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String occupation;
    private String address;
    private long monthlyEarning;
}
