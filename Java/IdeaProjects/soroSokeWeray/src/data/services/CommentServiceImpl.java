package data.services;

import data.models.Comment;
import data.repositories.CommentRepository;
import data.repositories.CommentRepositoryImpl;

public class CommentServiceImpl implements CommentService{

    @Override
    public String addComment(String comment, int postId) {
        Comment userComment = new Comment();
        userComment.setCommentText(comment);
        userComment.setPostId(postId);
        commentRepo.save(userComment, postId);
        return toString(userComment);
    }
    public String toString(Comment userComment){
        return String.format("""
                Comment Id: %d
                Comment: %s
                """, userComment.getCommentId(), userComment.getCommentText());
    }
    @Override
    public Comment findCommentById(int commentId) {
        return null;
    }
    private CommentRepository commentRepo = new CommentRepositoryImpl();
}
