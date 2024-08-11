package com.semicolon.africa.data.services;

import com.semicolon.africa.data.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

public interface PostService {
    String createPost(String title, String content);
    String editPost(String title, String newContent);
    String viewPost(String title);
    String delete(String title);
    String sharePost(String title);
}
