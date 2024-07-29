package data.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    public Date getCreatedAt(){
        return createdAt;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int id) {
        this.postId = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComments(Comment comment) {
        this.comments.add(comment);
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private int postId;
    private String content;
    private Date updatedAt;
    private String title;
    private List<Comment> comments = new ArrayList<>();
    private Date createdAt;

}
