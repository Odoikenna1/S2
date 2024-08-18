package com.semicolon.africa.web;

import com.semicolon.africa.dtos.request.SearchProductRequest;
import com.semicolon.africa.dtos.response.ApiResponse;
import com.semicolon.africa.dtos.response.ProductFoundResponse;
import com.semicolon.africa.services.CartServices;
import com.semicolon.africa.services.CartServicesImpl;
import com.semicolon.africa.services.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController {

    private final ProductServices productServices;

    @GetMapping("api/odomart/productsearch")
    public ResponseEntity<?> searchProduct(@RequestBody SearchProductRequest searchProductRequest){
        try{
            ProductFoundResponse productFoundResponse = productServices.findProductBy(searchProductRequest);
            return new ResponseEntity(new ApiResponse(productFoundResponse, true), HttpStatus.ACCEPTED);
        }catch(Exception error){
            return new ResponseEntity<>(new ApiResponse(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
}
