package com.jokerapp.model;

public class JokeItem {
    private int id;
    private String imageUrl;
    private String title;
    private String ownerName;

    public JokeItem(int id, String imageUrl, String title, String ownerName) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.ownerName = ownerName;
        this.id = id;
    }

    public String getImageUrl() { return imageUrl; }
    public String getTitle() { return title; }
    public String getOwnerName() { return ownerName; }
    public  int getId(){return id;}
}
