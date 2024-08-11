package com.semicolon.africa.services;

import com.semicolon.africa.data.models.Customer;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.UserRepository;
import com.semicolon.africa.dtos.request.LogInRequest;
import com.semicolon.africa.dtos.request.RegisterUserAuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class CustomerServicesImpl implements CustomerServices{

    private final UserRepository userRepository;

    @Override
    public Customer registerCustomer(RegisterUserAuthenticationRequest registerUserAuthenticationRequest) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(registerUserAuthenticationRequest.getFirstName());
        newCustomer.setLastName(registerUserAuthenticationRequest.getLastName());
        newCustomer.setUserName(registerUserAuthenticationRequest.getUserName());
        newCustomer.setCreditCard(registerUserAuthenticationRequest.getCreditCardInfo());
        newCustomer.setBillingAddress(registerUserAuthenticationRequest.getAddress());
        newCustomer.setGender(registerUserAuthenticationRequest.getGender());
        newCustomer.setSessionStatus(registerUserAuthenticationRequest.getSessionStatus());
        newCustomer.setDateOfBirth(registerUserAuthenticationRequest.getDateOfBirth());
        newCustomer.setRole(registerUserAuthenticationRequest.getRole());
        User customerToUser = newCustomer;
        User customerSaved = userRepository.save(customerToUser);
        return (Customer) customerSaved;
    }

    @Override
    public Customer findCustomerBy(String customerId) {
        Customer customerFound =  (Customer) userRepository.findUserById(customerId);
        return customerFound;
    }

    @Override
    public boolean validateCustomer(LogInRequest logInRequest) {
        Customer customerFound = findCustomerBy(logInRequest.getUserId());
        boolean userName = customerFound.getUserName().equals(logInRequest.getUserName());
        boolean passwordIsCorrect =  customerFound.getPassword().equals(logInRequest.getPassword());
        if(userName && passwordIsCorrect) return true;
        return false;
    }


}
