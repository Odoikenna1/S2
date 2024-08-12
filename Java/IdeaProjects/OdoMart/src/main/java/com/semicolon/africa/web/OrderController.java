package com.semicolon.africa.web;

import com.semicolon.africa.data.domain.Order;
import com.semicolon.africa.dtos.request.CheckOutRequest;
import com.semicolon.africa.dtos.response.ApiResponse;
import com.semicolon.africa.dtos.response.CheckOutResponse;
import com.semicolon.africa.services.OrderServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {


    private final OrderServices orderServices;


    @PostMapping("api/v1/order")
    public ResponseEntity<?> createOrder(@RequestBody  CheckOutRequest checkOutRequest){
        try{
            CheckOutResponse checkOutResponse = orderServices.createAnOrder(checkOutRequest);
            return new ResponseEntity<>(new ApiResponse(checkOutResponse, true), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);

        }
    }

}
