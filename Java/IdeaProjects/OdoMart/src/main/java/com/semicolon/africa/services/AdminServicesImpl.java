package com.semicolon.africa.services;

import com.semicolon.africa.data.models.Admin;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.request.LogInRequest;
import com.semicolon.africa.dtos.request.RegisterUserAuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class AdminServicesImpl implements AdminServices {

    private final UserRepository userRepository;

    @Override
    public Admin createAdmin(RegisterUserAuthenticationRequest registerUserAuthenticationRequest) {
        Admin administrativeUser = new Admin();
        administrativeUser.setFirstName(registerUserAuthenticationRequest.getFirstName());
        administrativeUser.setLastName(registerUserAuthenticationRequest.getLastName());
        administrativeUser.setBrandName(registerUserAuthenticationRequest.getBrandName());
        administrativeUser.setRole(registerUserAuthenticationRequest.getRole());
        administrativeUser.setGender(registerUserAuthenticationRequest.getGender());
        administrativeUser.setSessionStatus(registerUserAuthenticationRequest.getSessionStatus());
        Admin adminUserSaved = userRepository.save(administrativeUser);
        return adminUserSaved;
    }

    @Override
    public boolean validateAdmin(LogInRequest logInRequest) {
        Admin adminFound = (Admin) userRepository.findUserById(logInRequest.getUserId());
        boolean adminBrandName = adminFound.getBrandName().equals(logInRequest.getBrandName());
        boolean adminPasswordIsCorrect = adminFound.getPassword().equals(logInRequest.getPassword());
        if (adminBrandName && adminPasswordIsCorrect) return true;
        else return false;
    }

}
