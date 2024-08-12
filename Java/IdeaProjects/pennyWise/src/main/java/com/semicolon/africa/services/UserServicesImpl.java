package com.semicolon.africa.services;

import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.requests.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class UserServicesImpl implements UserServices{

    private final UserRepository userRepository;

    @Override
    public User createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setAddress(createUserRequest.getAddress());
        user.setOccupation(createUserRequest.getOccupation());
        user.setMonthlyEarning(createUserRequest.getMonthlyEarning());
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
