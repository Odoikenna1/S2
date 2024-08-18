package com.semicolon.africa.web;

import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.*;
import com.semicolon.africa.services.CartServices;
import com.semicolon.africa.services.CartServicesImpl;
import com.semicolon.africa.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;
    private final CartServices cartServices;

    @PostMapping("api/odomart/signup")
    public ResponseEntity<?> signUp(@RequestBody RegisterUserRequest registerUserRequest){
        try{
            UserSignUpResponse feedBack = userServices.signUp(registerUserRequest);
            return new ResponseEntity(new ApiResponse(feedBack, true), HttpStatus.CREATED);
        } catch (Exception error){
            return new ResponseEntity<>(new ApiResponse(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("api/ododmart/exit")
    public ResponseEntity<?> logOut(@RequestBody LogOutRequest logOutRequest){
        try{
            LogOutResponse response = userServices.logOut(logOutRequest);
            return new ResponseEntity<>(new ApiResponse(response, true), HttpStatus.ACCEPTED);
        }catch(Exception error){
            return new ResponseEntity<>(new ApiResponse(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("api/odomart/cart")
    public ResponseEntity<?> addToCart(@RequestBody AddToCartRequest addToCartRequest){
        try{
            AddToCartResponse addToCartResponse = cartServices.addToCart(addToCartRequest);
            return new ResponseEntity(addToCartResponse , HttpStatus.CREATED);
        } catch(Exception error){
            return new ResponseEntity<>(new ApiResponse(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("api/odomart/user")
    public ResponseEntity<?> increaseItemInCart(IncreaseItemQuantityRequest increaseItemQuantityRequest){
        try{
            IncreaseQuantityResponse newValue = cartServices.increaseItemQuantity(increaseItemQuantityRequest);
            return new ResponseEntity<>(newValue, HttpStatus.ACCEPTED);
        }catch(Exception error){
            return new ResponseEntity<>(new ApiResponse(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping("api/odomart/reduceitemquantity")
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
