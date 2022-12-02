package com.example.forumproject.model;

import org.springframework.data.annotation.Id;

public class Post {

    @Id
    private String id;

    private String title;
    private String text;

    private String threadId;
    private Integer type;

    private Integer visibility;

    public Post() {

    }

    public Post(String title, String text, String threadId, Integer type, Integer visibility) {
        this.title = title;
        this.text = text;
        this.threadId = threadId;
        this.type = type;
        this.visibility = visibility;
    }

    public Post(String id, String title, String text, String threadId, Integer type, Integer visibility) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.threadId = threadId;
        this.type = type;
        this.visibility = visibility;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }
}
