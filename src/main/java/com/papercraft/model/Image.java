package com.papercraft.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Image implements Serializable {
    public Integer id;
    public Integer entityId;
    public String entityType;
    public String imgName;
    public Boolean isThumbnail;
    public Timestamp createdAt;

    public Image(Integer id, Integer entityId, String entityType, String imgName, Boolean isThumbnail, Timestamp createdAt) {
        this.id = id;
        this.entityId = entityId;
        this.entityType = entityType;
        this.imgName = imgName;
        this.isThumbnail = isThumbnail;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Boolean getThumbnail() {
        return isThumbnail;
    }

    public void setThumbnail(Boolean thumbnail) {
        isThumbnail = thumbnail;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}


