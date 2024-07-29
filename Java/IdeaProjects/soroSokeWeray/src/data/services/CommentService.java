package data.services;

import data.models.Comment;

public interface CommentService {
    String addComment(String comment, int postId);
    Comment findCommentById(int commentId);
}
