package data.repositories;

import data.models.Post;

import java.util.List;

public interface PostRepository {
    Post findByPostId(int id);

    List<Post> findAll();

    long count();

    void deleteAll();

    void save(Post post);

    void deleteById(int id);

    boolean isEmpty();
}
