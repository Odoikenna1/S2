package data.services;

import data.models.Post;
import data.repositories.CommentRepositoryImpl;
import data.repositories.PostRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentServiceImplTest {
    @Test
    void test_CommentCanBeCreatedWithContentAndPostId(){
        Post post = new Post();
        PostRepositoryImpl postRepo = new PostRepositoryImpl();
        postRepo.save(post);

        CommentServiceImpl commentService = new CommentServiceImpl();
        commentService.addComment("News no one wants to hear", post.getPostId());
        CommentRepositoryImpl commentRepository = new CommentRepositoryImpl();

        assertEquals(1, commentRepository.count());



    }
}
