package data.repositories;

import data.models.Comment;

import java.util.List;

public interface CommentRepository {

    List<Comment> findAll();
    void save(Comment comment, int postId);
    long count();
    void delete(Comment comment);
    void deleteAll();
    boolean isEmpty();
    void deleteByCommentId(int commentId);
    Comment findByCommentId(int commentId);
    void deleteByPostId(int postId);
    Comment findByPostId(int postId);
}
