package com.semicolon.africa.services;
import com.semicolon.africa.data.domain.Role;
import com.semicolon.africa.data.domain.SessionStatus;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.LogInResponse;
import com.semicolon.africa.dtos.response.LogOutResponse;
import com.semicolon.africa.dtos.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices{
    private final CartServices cartService;

    private final UserRepository userRepository;
    private final CustomerServices customerServices;
    private final AdminServices adminServices;

    @Override
    public RegisterResponse signUp(@NotNull RegisterUserAuthenticationRequest signUpRequestData) {
        User userRegistered = setUpUser(signUpRequestData);
        String name = userRegistered.getFirstName();
        String userId = userRegistered.getId();
        String userAddress = userRegistered.getAddress();
        return new RegisterResponse(userRegistered.getFirstName(), name +" your account has been created successfully.", userId, userAddress);
    }

    @Override
    public User findUserById(String userId) {
        User found = userRepository.findUserById(userId);
        return found;
    }

    @Override
    public LogOutResponse logOut(LogOutRequest logOutRequest) {
        LogOutResponse logOutResponse = new LogOutResponse();
        User userFound = userRepository.findUserById(logOutRequest.getUserId());
        if(userFound.getSessionStatus() == SessionStatus.LOGGED_IN) {
            logOutRequest.setUserId(userFound.getId());
            logOutResponse.setSessionStatus(SessionStatus.LOGGED_OUT);
            return logOutResponse;
        }
        throw new IllegalArgumentException("Invalid request.");
    }

    @Override
    public LogInResponse verifyLoginDetails(LogInRequest logInRequest) {
        LogInResponse logInResponse = new LogInResponse();
        User userFound = findUserById(logInRequest.getUserId());
        boolean email  = userFound.getEmail() == logInRequest.getEmail();
        boolean passwordIsCorrect = userFound.getPassword() == logInRequest.getPassword();
        if(email && passwordIsCorrect){
            logInResponse.setUserId(userFound.getId());
            logInResponse.setSessionStatus(SessionStatus.LOGGED_IN);
            return logInResponse;
        }
        throw new IllegalArgumentException("Invalid request.");
    }

    private User setUpUser(@NotNull RegisterUserAuthenticationRequest registerUserRequest) {
        if (registerUserRequest.getRole() == Role.CUSTOMER) {
            return customerServices.registerCustomer(registerUserRequest);
        }
        return adminServices.createAdmin(registerUserRequest);
    }

}


