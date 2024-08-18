package com.semicolon.africa.services;
import com.semicolon.africa.data.domain.Product;
import com.semicolon.africa.dtos.request.CreateProductRequest;
import com.semicolon.africa.dtos.request.SearchProductRequest;
import com.semicolon.africa.dtos.response.ProductFoundResponse;

public interface ProductServices {
    public Product addProduct(CreateProductRequest createProductRequest);
    public ProductFoundResponse findProductBy(SearchProductRequest searchProductRequest);
}
