package com.semicolon.africa.services;
import com.semicolon.africa.data.domain.Product;
import com.semicolon.africa.dtos.request.InitializeProductRequest;

public interface ProductServices {
    public Product addProduct(InitializeProductRequest initializeProductRequest);
}
