package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<ShoppingCart, String> {
    public ShoppingCart findCartByUserId(String userId);
}
