package com.semicolon.africa.web;

import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.AddToCartResponse;
import com.semicolon.africa.dtos.response.ApiResponse;
import com.semicolon.africa.dtos.response.RegisterResponse;
import com.semicolon.africa.services.CartServices;
import com.semicolon.africa.services.CartServicesImpl;
import com.semicolon.africa.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;
    private final CartServicesImpl cartServicesImpl;
    private final CartServices cartServices;

    @PostMapping("api/v1/signup")
    public ResponseEntity<?> signUp(RegisterUserAuthenticationRequest registerUserRequest){
        try{
            RegisterResponse feedBack = userServices.signUp(registerUserRequest);
            return new ResponseEntity(new ApiResponse(feedBack, true), HttpStatus.CREATED);
        } catch (Exception error){
            return new ResponseEntity<>(new ApiResponse(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping("")
    public ResponseEntity<?> addToCart(AddToCartRequest addToCartRequest){
        try{
            AddToCartResponse addToCartResponse = cartServices.addToCart(addToCartRequest);
            return new ResponseEntity(new AddToCartResponse(), HttpStatus.CREATED);
        } catch(Exception error){
            return new ResponseEntity<>(new ApiResponse(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping()
    public ResponseEntity<?> increaseItemInCart(IncreaseItemQuantityRequest increaseItemQuantityRequest){
        try{
            int newValue = cartServices.increaseItemQuantity(increaseItemQuantityRequest);
            return new ResponseEntity<>(newValue, HttpStatus.ACCEPTED);
        }catch(Exception error){
            return new ResponseEntity<>(new ApiResponse(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping()
    public ResponseEntity<?> reduceQuantity(ReduceItemQuantityRequest reduceItemQuantityRequest){
        try{
           int updatedQuantity =  cartServices.reduceItemQuantity(reduceItemQuantityRequest);
        return new ResponseEntity<>(updatedQuantity, HttpStatus.ACCEPTED);
        }catch(Exception error){
            return new ResponseEntity<>(new ApiResponse(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
//    @RequestMapping
//    public ResponseEntity<?> removeItemFromCart(RemoveItemFromCartRequest removeItemFromCartRequest){
//        try{
//            int x = cartServices.removeItemFromCart(removeItemFromCartRequest);
//        }
//    }
}
