package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.SessionStatus;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.LogInResponse;
import com.semicolon.africa.dtos.response.LogOutResponse;
import com.semicolon.africa.dtos.response.RegisterResponse;

public interface UserServices {
    public RegisterResponse signUp(RegisterUserAuthenticationRequest userData);
    public User findUserById(String userId);
    public LogOutResponse logOut(LogOutRequest logOutRequest);
    public LogInResponse verifyLoginDetails(LogInRequest logInRequest);
}
