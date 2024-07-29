package data.repositories;
import data.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPostRepositoryTest {
    private PostRepositoryImpl postImpl;

    @BeforeEach
    void setUp() {
        postImpl = new PostRepositoryImpl();
    }
    @Test
    void test_addPost(){
        Post newPost = new Post();
        postImpl.save(newPost);
        long numberOfPosts = postImpl.count();
        assertEquals(1, numberOfPosts);
    }
    @Test
    void test_that_number_ofPosts_increaseTo2afterAddingAnotherPost(){
        Post newPost = new Post();
        postImpl.save(newPost);
        Post anotherPost = new Post();
        postImpl.save(anotherPost);
        long numberOfPosts = postImpl.count();
        assertEquals(2, numberOfPosts);
    }
    @Test
    void test_deleteById(){
        Post newPost = new Post();
        postImpl.save(newPost);
        Post anotherPost = new Post();
        postImpl.save(anotherPost);
        postImpl.deleteById(2);
        long numberOfPosts = postImpl.count();
        assertEquals(1, numberOfPosts);
    }
    @Test
    void test_deleteAll(){
        Post newPost = new Post();
        postImpl.save(newPost);
        Post anotherPost = new Post();
        postImpl.save(anotherPost);
        postImpl.deleteAll();
        long numberOfPosts = postImpl.count();
        assertEquals(0, numberOfPosts);
    }
    @Test
    void test_that_PostIdSets1WhenSaved(){
        Post post = new Post();
        post.setTitle("Lebron for the win.");
        postImpl.save(post);
        assertEquals( 1, post.getPostId());
    }
    @Test
    void test_that_PostIdSets2_WhenSecondPostIsSaved(){
        Post post = new Post();
        post.setTitle("Lebron for the win.");
        postImpl.save(post);
        assertEquals( 1, post.getPostId());

        Post post2 = new Post();
        post2.setTitle("Aston villa scores a fantastic goal against Chelsea.");
        postImpl.save(post2);
        assertEquals( 2, post2.getPostId());
    }
    @Test
    void test_that_PostIdSets3_When_ThirdPostIsSaved(){
        Post post = new Post();
        post.setTitle("Lebron for the win.");
        postImpl.save(post);
        assertEquals( 1, post.getPostId());

        Post post2 = new Post();
        post2.setTitle("Aston villa scores a fantastic goal against Chelsea.");
        postImpl.save(post2);
        assertEquals( 2, post2.getPostId());

        Post post3 = new Post();
        post3.setTitle("Nigeria begins construction of 4th mainland bridge.");
        postImpl.save(post3);
        System.out.printf("Post 1 Id: %d\nPost 2 Id: %d\nPost 3 Id: %d", post.getPostId(), post2.getPostId(), post3.getPostId());
        assertEquals(3, post3.getPostId());
    }
}