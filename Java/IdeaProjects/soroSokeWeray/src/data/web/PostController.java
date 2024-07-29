package data.web;

import data.services.PostService;
import data.services.PostServiceImpl;

public class PostController {

    public String createPost(String title, String content){
        return postService.addPost(title, content);
    }
    public String getPost(int postId){
        return postService.findByPostId(postId).toString();
    }
    private PostService postService = new PostServiceImpl();
}
