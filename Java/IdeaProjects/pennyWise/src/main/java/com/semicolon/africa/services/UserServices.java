package com.semicolon.africa.services;

import com.semicolon.africa.data.models.User;
import com.semicolon.africa.dtos.requests.CreateUserRequest;

public interface UserServices {
    public User createUser(CreateUserRequest createUserRequest);
}
