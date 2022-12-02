package com.example.forumproject.service;

import com.example.forumproject.commons.GenericServiceImpl;
import com.example.forumproject.model.Post;
import com.example.forumproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends GenericServiceImpl<Post, String> implements PostServiceAPI{

    @Autowired
    PostRepository postRepository;
    @Override
    public CrudRepository<Post, String> getDao() {
        return postRepository;
    }
}
