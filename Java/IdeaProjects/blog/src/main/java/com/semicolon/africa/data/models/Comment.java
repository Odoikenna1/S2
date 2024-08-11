package com.semicolon.africa.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Data @NoArgsConstructor public class Comment {

    @Id public String id;
    private String commentText;
    private String userId;
    private String postId;
    public LocalDateTime createdAt = LocalDateTime.now();
}
