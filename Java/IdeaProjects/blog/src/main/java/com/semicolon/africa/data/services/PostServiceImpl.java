package com.semicolon.africa.data.services;

import com.semicolon.africa.data.models.Post;
import com.semicolon.africa.data.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor public class PostServiceImpl implements PostService{

    private PostRepository repo;

    
   @Autowired @Lazy public void setPostRepository(PostRepository repo){
       this.repo = repo;
   }

    @Override
    public String createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title); post.setContent(content);
        repo.save(post);
        return String.format ("""
                Title: %s
                Content: %s
                """, post.getTitle(), post.getContent());
    }

    @Override
    public String editPost(String title, String newContent) {
       Post foundPost = repo.findPostByTitle(title);
        foundPost.setContent(newContent);
        repo.save(foundPost);
        return "Post updated successfully.";
    }

    @Override
    public String viewPost(String title) {
       Post postFound = repo.findPostByTitle(title);
        return String.format("""
                Title: %s
                Content: %s
                """, postFound.getTitle(), postFound.getContent());
    }

    @Override
    public String delete(String title) {
       Post postFound = repo.findPostByTitle(title);
       repo.delete(postFound);
        return "Post has been deleted.";
    }

    @Override
    public String sharePost(String title) {
        return "";
    }
}
