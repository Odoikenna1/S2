package com.semicolon.africa.web;

import com.semicolon.africa.dtos.request.RegisterUserAuthenticationRequest;
import com.semicolon.africa.dtos.response.ApiResponse;
import com.semicolon.africa.dtos.response.RegisterResponse;
import com.semicolon.africa.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;

    @PostMapping("api/v1/signup")
    public ResponseEntity<?> signUp(RegisterUserAuthenticationRequest registerUserRequest){
        try{
            RegisterResponse feedBack = userServices.signUp(registerUserRequest);
            return new ResponseEntity(new ApiResponse(feedBack, true), HttpStatus.CREATED);
        } catch (Exception error){
            return new ResponseEntity<>(new ApiResponse(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
}
