package com.example.forumproject.repository;

import com.example.forumproject.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{threadId:'?0'}")
    public List<Post> filterByThread(String threadId);

}
