package data.services;

import data.models.Post;

public interface PostService {
    String addPost(String title, String content);
    Post findByPostId(int id);
}
