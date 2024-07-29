package data.models;

import java.time.LocalDateTime;
public class Comment {

    public int getCommentId() {
        return commentId;
    }
    public void setCommentId(int commentId){
        this.commentId = commentId;
    }
    public void setCommentCreatedAt(){
        this.commentCreatedAt = LocalDateTime.now();
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    private String commentText;
    private int userId;
    private int commentId;
    private int postId;
    private LocalDateTime commentCreatedAt;
}
