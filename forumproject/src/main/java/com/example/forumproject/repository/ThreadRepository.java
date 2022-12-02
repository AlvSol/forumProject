package com.example.forumproject.repository;

import com.example.forumproject.model.ThreadForum;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThreadRepository extends MongoRepository<ThreadForum, String> {

}
