package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Product;
import com.semicolon.africa.data.repositories.ProductRepository;
import com.semicolon.africa.dtos.request.InitializeProductRequest;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServicesImpl implements ProductServices{

    private final ProductRepository productRepo;

    @Override
    public Product addProduct(@NotNull InitializeProductRequest initializeProductRequest) {
        Product product = new Product();
        product.setName(initializeProductRequest.getName());
        product.setPrice(initializeProductRequest.getPrice());
        Product savedProduct = productRepo.save(product);
        return savedProduct;
    }
}
