package data.models;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.time.LocalDateTime;

@JsonAnySetter
public class Post {
    private String postId;
    private String title;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
}
