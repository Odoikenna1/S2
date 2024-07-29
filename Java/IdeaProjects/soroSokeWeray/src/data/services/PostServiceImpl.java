package data.services;

import data.models.Post;
import data.repositories.PostRepository;
import data.repositories.PostRepositoryImpl;

public class PostServiceImpl implements PostService{
    @Override
    public String addPost(String title, String content) {
        Post post = new Post();
        if(titleExistFor(title)){throw new IllegalArgumentException("Title already exists.");}
        post.setTitle(title);post.setContent(content);postRepositoryImpl.save(post);
        return postToString(post);
    }
    private String postToString(Post post){
        return String.format("""
                Title: %s
                Post Id: %s
                Content: %s
                """, post.getTitle(), post.getPostId(), post.getContent());
    }
    @Override
    public Post findByPostId(int id) {

        return postRepositoryImpl.findByPostId(id);
    }
    private boolean titleExistFor(String title){
        for(Post post :  postRepositoryImpl.findAll()){
            if(title.equalsIgnoreCase(post.getTitle()))
            {return true;}
        }
        return false;
    }

    private PostRepository postRepositoryImpl = new PostRepositoryImpl();

}
