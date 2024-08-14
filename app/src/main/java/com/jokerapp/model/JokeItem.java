package com.jokerapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


public class JokeItem {

    private String _id;
    private String text;
    private String title;
    private String ownerName;
    private String ownerId;

    public  JokeItem(){}

    public JokeItem(String _id, String title, String ownerName, String ownerId, String text) {
        this.title = title;
        this.ownerName = ownerName;
        this._id = _id;
        this.text = text;
        this.ownerId = ownerId;

    }
    public String getText() {
        return text;
    }

    public String getTitle() { return title; }
    public String getOwnerName() { return ownerName; }
    public String getId(){return _id;}
    public String getOwnerId(){return  ownerId;}
    public void setText(String text) {
        this.text = text;
    }
    public void setId(String id) {
        this._id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

}
