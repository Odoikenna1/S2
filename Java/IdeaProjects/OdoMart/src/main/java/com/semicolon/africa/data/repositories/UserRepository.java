package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByUserId(String id);
    boolean existsByEmail(String userEmail);
    boolean existsByUserId(String userId);
}
