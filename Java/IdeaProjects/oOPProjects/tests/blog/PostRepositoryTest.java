package blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostRepositoryTest {
    private PostRepositoryImpl postImpl;
    @BeforeEach
    void setUp(){
         postImpl = new PostRepositoryImpl();
    }
    @Test
    void test_addPost(){
        Post newPost = new Post();
        newPost.setId(12);
        postImpl.save(newPost);
        long numberOfPosts = postImpl.count();
        assertEquals(1, numberOfPosts);
    }
    @Test
    void test_that_number_ofPosts_increaseTo2afterAddingAnotherPost(){
        Post newPost = new Post();
        newPost.setId(12);
        postImpl.save(newPost);
        Post anotherPost = new Post();
        anotherPost.setId(15);
        postImpl.save(anotherPost);
        long numberOfPosts = postImpl.count();
        assertEquals(2, numberOfPosts);
    }
    @Test
    void test_deleteById(){
        Post newPost = new Post();
        newPost.setId(12);
        postImpl.save(newPost);
        Post anotherPost = new Post();
        anotherPost.setId(15);
        postImpl.save(anotherPost);
        postImpl.deleteById(12);
        long numberOfPosts = postImpl.count();
        assertEquals(1, numberOfPosts);
    }
    @Test
    void test_deleteAll(){
        Post newPost = new Post();
        newPost.setId(12);
        postImpl.save(newPost);
        Post anotherPost = new Post();
        anotherPost.setId(15);
        postImpl.save(anotherPost);
        postImpl.deleteAll();
        long numberOfPosts = postImpl.count();
        assertEquals(0, numberOfPosts);
    }
}
