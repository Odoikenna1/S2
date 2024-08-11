package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.SessionStatus;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.RegisterResponse;

public interface UserServices {
    public RegisterResponse signUp(RegisterUserAuthenticationRequest userData);
    public boolean verifyLogIn(LogInRequest logInRequest);
//    public SessionStatus logOut(LogOutRequest logOutRequest);
//    public User findUserById(String userId);
    public String addToCart(AddToCartRequest requestedItem);
    public String removeItemFromCart(UpdateCartRequest updateCartRequest);
}
