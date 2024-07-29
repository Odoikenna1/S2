package data.repositories;

import data.models.*;
import data.repositories.PostRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {

    private CommentRepositoryImpl commentImpl;
    private PostRepositoryImpl postRepo;

    @BeforeEach
    void setUp(){
        commentImpl = new CommentRepositoryImpl();
        postRepo = new PostRepositoryImpl();
    }
    @Test
    void test_thatListOfCommentsIsEmpty(){
        boolean listIsEmpty = commentImpl.isEmpty();
        assertTrue(listIsEmpty);
    }
    @Test
    void test_thatListIsNotEmptyWhenCommentIsCreatedAndSaved(){
        Post post = new Post();
        postRepo.save(post);
        Comment userComment = new Comment();
        userComment.setCommentText("Hi");
        commentImpl.save(userComment, post.getPostId());
        boolean listIsEmpty = commentImpl.isEmpty();
        assertFalse(listIsEmpty);
    }
    @Test
    void test_that_CommentListCountIs_0_WhenListIsEmpty(){
        assertEquals(0, commentImpl.count());
    }
    @Test
    void test_that_CommentListCountIs_1_WhenOneListIsAddedToList(){
        Post post = new Post();
        postRepo.save(post);
        Comment userComment = new Comment();
        userComment.setCommentText("hi");
        commentImpl.save(userComment, post.getPostId());
        assertEquals( 1, commentImpl.count());
    }
    @Test
    void test_that_CommentListCountIs_4_WhenListHas_3_CommentsAnd_OneIsAddedToTheList(){
        Post post = new Post();
        postRepo.save(post);
        Comment userComment = new Comment();
        userComment.setCommentText("hi");
        commentImpl.save(userComment, post.getPostId());

        Post post2 = new Post();
        postRepo.save(post2);
        Comment userComment2 = new Comment();
        userComment2.setCommentText("hey");
        commentImpl.save(userComment2, post2.getPostId());

        Post post3 = new Post();
        postRepo.save(post3);
        Comment userComment3 = new Comment();
        userComment3.setCommentText("hey");
        commentImpl.save(userComment3, post3.getPostId());
        assertEquals( 3, commentImpl.count());

        Post post4 = new Post();
        postRepo.save(post4);
        Comment userComment4 = new Comment();
        userComment4.setCommentText("hey");
        commentImpl.save(userComment4, post4.getPostId());
        assertEquals( 4, commentImpl.count());
    }
    @Test
    void test_thatCommentCanBeFoundByCommentId(){
        Post post = new Post();
        postRepo.save(post);
        Comment userComment = new Comment();
        userComment.setCommentText("Hi");
        commentImpl.save(userComment, post.getPostId());
        Comment commentFound = commentImpl.findByCommentId(1);
        assertEquals(commentFound.getCommentId(), userComment.getCommentId());
    }
    @Test
    void test_thatCommentCanBeFoundByPostId(){
        Post post = new Post();
        postRepo.save(post);
        Comment userComment = new Comment();
        userComment.setCommentText("lol");
        commentImpl.save(userComment, post.getPostId());
    }
    @Test
    void test_that_CommentCanBeDeletedByCommentId(){
        Post post = new Post();
        postRepo.save(post);
        Comment userComment = new Comment();
        commentImpl.save(userComment, post.getPostId());

        Post post2 = new Post();
        postRepo.save(post2);
        Comment userComment2 = new Comment();
        commentImpl.save(userComment2, post.getPostId());

        Post post3 = new Post();
        postRepo.save(post3);
        Comment userComment3 = new Comment();
        commentImpl.save(userComment3, post3.getPostId());
        commentImpl.deleteByCommentId(2);
        assertEquals(2, commentImpl.count());
    }
    @Test
    void test_ThatCommentId_Matches_PostId(){
        Post newPost = new Post();
        newPost.setTitle("King scores a basket");
        postRepo.save(newPost);

        Comment userComment = new Comment();
        userComment.setCommentText("bye");
        userComment.setPostId(newPost.getPostId());

        commentImpl.save(userComment, newPost.getPostId());

        long postId = userComment.getPostId();
        long commentId = userComment.getCommentId();
        assertEquals(postId, commentId);
    }
    @Test
    void test_that_CommentCanBeFoundWith_PostId(){ //Fix this method, the postId doesn't increase
        Post newPost = new Post();
        newPost.setTitle("New British PM is weighing in on tax cuts for big tech Companies.");
        PostRepositoryImpl postImpl = new PostRepositoryImpl();
        postImpl.save(newPost);

        Comment userComment = new Comment();
        userComment.setCommentText("That new PM is sucking up to big tech companies, he lacks competence.");
        userComment.setPostId(newPost.getPostId());
        commentImpl.save(userComment, newPost.getPostId());
        Comment commentFound = commentImpl.findByPostId(newPost.getPostId());
        System.out.printf("Post with Id: %d\nComment with Post Id: %d", commentFound.getPostId(), newPost.getPostId());
        assertEquals(newPost.getPostId(), commentFound.getPostId());

        Post newPost2 = new Post();
        newPost2.setTitle("London bridge has fallen down.");
        PostRepositoryImpl postImpl2 = new PostRepositoryImpl();
        postImpl2.save(newPost2);

        Comment userComment2 = new Comment();
        userComment2.setCommentText("It's about damn time, that bridge has been standing for way too long.");
        userComment2.setPostId(newPost2.getPostId());
        commentImpl.save(userComment2, newPost2.getPostId());
        Comment commentToPostFound = commentImpl.findByPostId(newPost2.getPostId());
        System.out.printf("\nPost with Id: %d\nComment with Post Id: %d \n", commentToPostFound.getPostId(), newPost2.getPostId());
        assertEquals(1, commentToPostFound.getPostId());
    }
    @Test
    void test_that_AllCommentsUnder_a_PostCanBeReturned(){
        Post post = new Post();
        post.setTitle("Look out sapa season is here.");
        postRepo.save(post);

        Comment slurs = new Comment();
        slurs.setCommentText("Fuck the government.");
        commentImpl.save(slurs, post.getPostId());

        Post post2 = new Post();
        post2.setTitle("Big spending is now illegal says FG");
        postRepo.save(post2);

        Comment slurs2 = new Comment();
        slurs2.setCommentText("Fuck the government, again.");
        commentImpl.save(slurs2, post2.getPostId());
        System.out.println(commentImpl.findAll());
        List<Comment> comments = new ArrayList<>();
        comments.add(slurs);
        comments.add(slurs2);
        assertTrue(comments.containsAll(commentImpl.findAll()));
    }
    @Test
    void test_deleteComment(){
        Post post = new Post();
        postRepo.save(post);

        Comment comment1 = new Comment();
        commentImpl.save(comment1, post.getPostId());

        Post post2 = new Post();
        postRepo.save(post);

        Comment comment2 = new Comment();
        commentImpl.save(comment2, post.getPostId());

        Comment foundComment = commentImpl.findByCommentId(comment1.getCommentId());
        commentImpl.delete(foundComment);
        assertEquals(1, commentImpl.count());
    }
    @Test
    void test_that_deleteAll(){
        Post post = new Post();
        postRepo.save(post);

        Comment comment1 = new Comment();
        commentImpl.save(comment1, post.getPostId());

        Post post2 = new Post();
        postRepo.save(post);

        Comment comment2 = new Comment();
        commentImpl.save(comment2, post.getPostId());

        commentImpl.deleteAll();
        assertEquals(0, commentImpl.count());
    }
    @Test
    void test_that_Comment_Can_DeleteById(){
        Post post = new Post();
        postRepo.save(post);

        Comment comment1 = new Comment();
        commentImpl.save(comment1, post.getPostId());
        commentImpl.deleteByCommentId(comment1.getCommentId());
        assertEquals(0, commentImpl.count());
    }
}