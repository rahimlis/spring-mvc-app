package com.bakudynamics.mvc.dao;

import java.util.Date;

public class Post {
    private int id;
    private String title;
    private String text;
    private User user;
    private Date timestamp;
    private String imageUrl;

    public Post() {
        user = new User();
    }

    public Post(int id, String title, String text, User user, Date timestamp, String imageUrl) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.user = user;
        this.timestamp = timestamp;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getUsername() {
        return user.getUsername();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", timestamp=" + timestamp +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
