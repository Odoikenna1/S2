
package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Role;
import com.semicolon.africa.data.models.Admin;
import com.semicolon.africa.data.models.Customer;
import com.semicolon.africa.data.models.User;

import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices{
    private final CartServices cartService;

    private final CustomerServices customerServices;
    private final UserRepository userRepository;

    private final AdminServices adminServices;

    @Override
    public RegisterResponse signUp(@NotNull RegisterUserAuthenticationRequest signUpRequestData) {
        User userRegistered = setUpUser(signUpRequestData);
        String name = userRegistered.getFirstName();
        return new RegisterResponse(userRegistered.getFirstName(), name +" your account has been created successfully.", userRegistered);
    }

    @Override
    public boolean verifyLogIn(@NotNull LogInRequest logInRequest) {
        if(logInRequest.getRole() == Role.CUSTOMER){return customerServices.validateCustomer(logInRequest);};
        if(logInRequest.getRole() == Role.ADMIN){return adminServices.validateAdmin(logInRequest);}
        else throw new IllegalArgumentException("Bad request.");
    }


    @Override
    public String addToCart(AddToCartRequest requestedItem) {
        cartService.addToCart(requestedItem);

        return "";
    }

    @Override
    public String removeItemFromCart(UpdateCartRequest updateCartRequest) {
        return "";
    }

    private User setUpUser(@NotNull RegisterUserAuthenticationRequest registerUserRequest){
        if(registerUserRequest.getRole() == Role.CUSTOMER){
            Customer customerSaved = customerServices.registerCustomer(registerUserRequest);
            return customerSaved;
        } else { Admin adminSaved = adminServices.createAdmin(registerUserRequest); return adminSaved;}
    }

}


