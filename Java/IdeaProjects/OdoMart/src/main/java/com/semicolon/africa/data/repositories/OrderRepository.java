package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    public Order findByUserId(String userId);
    public List<Order> findAllBy(String userId);

}
