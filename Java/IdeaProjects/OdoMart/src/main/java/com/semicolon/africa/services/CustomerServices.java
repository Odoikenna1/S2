package com.semicolon.africa.services;

import com.semicolon.africa.data.models.Customer;
import com.semicolon.africa.dtos.request.FindCustomerByIdRequest;
import com.semicolon.africa.dtos.request.LogInRequest;
import com.semicolon.africa.dtos.request.RegisterUserAuthenticationRequest;

public interface CustomerServices {
    public Customer registerCustomer(RegisterUserAuthenticationRequest registerUserAuthenticationRequest);
    public Customer findCustomerBy(String customerId);
    public boolean validateCustomer(LogInRequest logInRequest);
}
