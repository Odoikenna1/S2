package com.semicolon.africa.services;

import com.semicolon.africa.data.models.User;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.LogInResponse;
import com.semicolon.africa.dtos.response.LogOutResponse;
import com.semicolon.africa.dtos.response.ProductFoundResponse;
import com.semicolon.africa.dtos.response.UserSignUpResponse;

public interface UserServices {
    public UserSignUpResponse signUp(RegisterUserRequest userData);
    public User findUserById(String userId);
    public LogOutResponse logOut(LogOutRequest logOutRequest);
    public boolean validateUserBy(String userId);
    public LogInResponse verifyLoginDetails(LogInRequest logInRequest);
}
