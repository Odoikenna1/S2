package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    public Product findProductById(String productId);
}
