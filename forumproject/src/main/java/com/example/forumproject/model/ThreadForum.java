package com.example.forumproject.model;

import org.springframework.data.annotation.Id;

public class ThreadForum {

    @Id
    private String id;

    private String name;

    public ThreadForum() {

    }

    public ThreadForum(String name) {
        this.name = name;
    }

    public ThreadForum(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
