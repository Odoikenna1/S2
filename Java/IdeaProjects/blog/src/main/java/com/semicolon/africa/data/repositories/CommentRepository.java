package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {


}
