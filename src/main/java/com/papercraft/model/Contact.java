package com.papercraft.model;

import java.io.Serializable;

public class Contact implements Serializable {
    public Integer id;
    public Integer userId;
    public String userFullname;
    public String contactTitle;
    public String content;
    public Boolean rely;

    public Contact(Integer id, Integer userId, String userFullname, String contactTitle, String content, Boolean rely) {
        this.id = id;
        this.userId = userId;
        this.userFullname = userFullname;
        this.contactTitle = contactTitle;
        this.content = content;
        this.rely = rely;
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

    public String getUserFullname() {
        return userFullname;
    }

    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getRely() {
        return rely;
    }

    public void setRely(Boolean rely) {
        this.rely = rely;
    }
}
