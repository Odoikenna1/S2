package com.semicolon.africa.services;

import com.semicolon.africa.data.domain.Product;
import com.semicolon.africa.data.repositories.ProductRepository;
import com.semicolon.africa.dtos.request.CreateProductRequest;
import com.semicolon.africa.dtos.request.SearchProductRequest;
import com.semicolon.africa.dtos.response.ProductFoundResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServicesImpl implements ProductServices{

    private final ProductRepository productRepo;

    @Override
    public Product addProduct(@NotNull CreateProductRequest createProductRequest) {
        Product product = new Product();
        product.setName(createProductRequest.getName());
        product.setPrice(createProductRequest.getPrice());
        product.setSellerId(createProductRequest.getSellerId());
        product.setStock(createProductRequest.getStock());
        product.setCategory(createProductRequest.getCategory());
        Product savedProduct = productRepo.save(product);
        return savedProduct;
    }

    @Override
    public ProductFoundResponse findProductBy(SearchProductRequest searchProductRequest) {
        ProductFoundResponse productFoundResponse = new ProductFoundResponse();
        Product productFound = productRepo.findProductByName(searchProductRequest.getProductName());
        productFoundResponse.setProduct(productFound);
        return productFoundResponse;
    }
}
