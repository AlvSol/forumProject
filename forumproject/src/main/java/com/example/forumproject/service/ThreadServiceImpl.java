package com.example.forumproject.service;

import com.example.forumproject.commons.GenericServiceImpl;
import com.example.forumproject.model.ThreadForum;
import com.example.forumproject.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ThreadServiceImpl extends GenericServiceImpl<ThreadForum, String> implements ThreadServiceAPI{

    @Autowired
    ThreadRepository threadRepository;
    @Override
    public CrudRepository<ThreadForum, String> getDao() {
        return threadRepository;
    }
}
