package data.repositories;

import data.models.Comment;
import data.models.Post;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{
    @Override
    public Comment findByCommentId(int commentId) {
        for(Comment comment : comments){if(comment.getCommentId() == commentId){ return comment;}}
        throw new IllegalArgumentException("Comment not found.");
    }
    @Override
    public List<Comment> findAll() {
        return comments;
    }
    @Override
    public void save(Comment comment, int postId) {
        comment.setCommentId(generateUniqueId());
        comment.setPostId(postId);
        comments.add(comment);
    }
    @Override
    public long count(){
        return comments.size();
    }
    @Override
    public void delete(Comment comment) {
        comments.remove(comment);
    }
    @Override
    public void deleteAll() {
        comments.clear();
    }
    @Override
    public boolean isEmpty() {
        return comments.isEmpty();
    }
    @Override
    public void deleteByCommentId(int commentId) {
        Comment commentFound = findByCommentId(commentId);
        comments.remove(commentFound);
    }
    @Override
    public void deleteByPostId(int postId) {
        Comment commentFound = findByPostId(postId);
        comments.remove(commentFound);
    }
    @Override
    public Comment findByPostId(int postId) {
        for(Comment comment : comments){
            if(postId == comment.getPostId()){
                return comment;
            }
        }
        throw new IllegalArgumentException("Comment not Found");
    }
    private int generateUniqueId(){
        return ++uniqueId;
    }
    private final List<Comment> comments = new ArrayList<Comment>();
    private boolean isEmpty = false;
    private int uniqueId = 0;
}
