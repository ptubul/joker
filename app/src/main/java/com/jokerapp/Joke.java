package com.jokerapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "jokes")
public class Joke {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String fullText;
    private int ownerID;

    public Joke( String title, String fullText, int ownerID) {
        this.title = title;
        this.fullText = fullText;
        this.ownerID = ownerID;
    }

    public  Joke(){

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

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }
}
