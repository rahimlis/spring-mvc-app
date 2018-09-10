package com.bakudynamics.mvc.dao;

import java.util.Date;

public class Comment {
    private int id;
    private String text;
    private User user;
    private Post post;
    private Date timestamp;

    public Comment(int id, String text, User user, Post post, Date timestamp) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.post = post;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", post=" + post +
                ", timestamp=" + timestamp +
                '}';
    }
}
