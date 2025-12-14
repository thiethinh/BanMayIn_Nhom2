package com.papercraft.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Blog implements Serializable {
    public Integer id;
    public Integer userId;
    public String blogTitle;
    public String typeBlog;
    public String blogContent;
    public Timestamp createdAt;

    public Blog() {}

    public Blog(Integer id, Integer userId, String blogTitle, String typeBlog, String blogContent, Timestamp createdAt) {
        this.id = id;
        this.userId = userId;
        this.blogTitle = blogTitle;
        this.typeBlog = typeBlog;
        this.blogContent = blogContent;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getTypeBlog() {
        return typeBlog;
    }

    public void setTypeBlog(String typeBlog) {
        this.typeBlog = typeBlog;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
