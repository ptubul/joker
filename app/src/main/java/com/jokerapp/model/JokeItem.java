package com.jokerapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


public class JokeItem {

    private String id;
//    private String imageUrl;

    private String title;
    private String ownerName;

    public  JokeItem(){}

    public void setId(String id) {
        this.id = id;
    }

//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public JokeItem(String id, String title, String ownerName) {
        this.title = title;
        this.ownerName = ownerName;
        this.id = id;
    }

//    public String getImageUrl() { return imageUrl; }
    public String getTitle() { return title; }
    public String getOwnerName() { return ownerName; }
    public String getId(){return id;}
}
