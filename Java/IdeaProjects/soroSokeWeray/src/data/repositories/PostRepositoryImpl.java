package data.repositories;

import data.models.Post;

import java.util.ArrayList;
import java.util.List;


public class PostRepositoryImpl implements PostRepository {

    @Override
    public Post findByPostId(int id) {
        for(Post post : posts){if(post.getPostId() == id){return post;}}
        throw new IllegalArgumentException("Post not found");
    }
    @Override
    public List<Post> findAll() {
        return posts;
    }
    @Override
    public long count() {
        return posts.size();
    }
    @Override
    public void deleteAll() {
        posts.clear();
    }
    @Override
    public void save(Post post) {
        post.setPostId(generateUniqueId());
        posts.add(post);
    }
    @Override
    public void deleteById(int id) {
        Post postFound = findByPostId(id);
        posts.remove(postFound);
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
    private int generateUniqueId(){
        return ++uniqueId;
    }

    private List<Post> posts = new ArrayList<Post>();
    private Post post = new Post();
    private int uniqueId = 0;
}
