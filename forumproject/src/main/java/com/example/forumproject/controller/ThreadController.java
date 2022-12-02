package com.example.forumproject.controller;


import com.example.forumproject.model.Post;
import com.example.forumproject.model.ThreadForum;
import com.example.forumproject.repository.PostRepository;
import com.example.forumproject.service.ThreadServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thread/api")
@CrossOrigin("*")
public class ThreadController {

    @Autowired
    ThreadServiceAPI threadServiceAPI;

    @Autowired
    PostRepository postRepository;

    @GetMapping(value="/all")
    public List<ThreadForum> getAll() {
        return threadServiceAPI.getAll();
    }

    @GetMapping(value="/allposts/{id}")
    public List<Post> getAllPosts(@PathVariable String id) {
        return postRepository.filterByThread(id);
    }

    @GetMapping(value = "/find/{id}")
    public ThreadForum find(@PathVariable String id) {
        return threadServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ThreadForum> save(@RequestBody ThreadForum thread) {
        ThreadForum obj = threadServiceAPI.save(thread);
        return new ResponseEntity<ThreadForum>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<ThreadForum> delete(@PathVariable String id) {
        ThreadForum obj = threadServiceAPI.get(id);
        if(obj != null) {
            threadServiceAPI.delete(id);
        } else {
            return new ResponseEntity<ThreadForum>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<ThreadForum>(obj, HttpStatus.OK);
    }
}
