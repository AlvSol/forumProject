package com.example.forumproject.controller;


import com.example.forumproject.commons.JSONparsing;
import com.example.forumproject.model.Post;
import com.example.forumproject.service.PostServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts/api")
@CrossOrigin("*")
public class PostController {

    private List<String> bannedList;

    @Autowired
    PostServiceAPI postServiceAPI;

    public PostController() {
        JSONparsing jsonParsing = new JSONparsing();
        bannedList = jsonParsing.getBannedWord();
    }

    @GetMapping(value="/all")
    public List<Post> getAll() {
        return postServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Post find(@PathVariable String id) {
        return postServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Post> save(@RequestBody Post post) {
        Post obj = postServiceAPI.save(post);
        return new ResponseEntity<Post>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Post> delete(@PathVariable String id) {
        Post obj = postServiceAPI.get(id);
        if(obj != null) {
            postServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Post>(obj, HttpStatus.OK);
    }

    @PostMapping(value = "/checkword")
    public Boolean checkBannedWords(@RequestBody String text) {
        String[] arr = text.split( "[\\s,]+" );

        for(String s: arr) {
            if(bannedList.contains(s)) {
                return false;
            }
        }

        return true;
    }

}
