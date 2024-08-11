package com.semicolon.africa.services;

import com.semicolon.africa.data.models.Admin;
import com.semicolon.africa.dtos.request.LogInRequest;
import com.semicolon.africa.dtos.request.RegisterUserAuthenticationRequest;

public interface AdminServices {
    public Admin createAdmin(RegisterUserAuthenticationRequest registerUserAuthenticationRequest);
    public boolean validateAdmin(LogInRequest logInRequest);
}
