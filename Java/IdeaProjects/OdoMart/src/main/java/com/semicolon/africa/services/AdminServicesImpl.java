package com.semicolon.africa.services;

import com.semicolon.africa.data.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class AdminServicesImpl implements AdminServices {

    private final UserRepository userRepository;



}
