package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PostRepository extends MongoRepository<Post, String> {
    Post findPostByTitle(String title);
}
