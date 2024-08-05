package com.jokerapp.model;

public class JokeItem {
    private String imageUrl;
    private String title;
    private String ownerName;

    public JokeItem(String imageUrl, String title, String ownerName) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.ownerName = ownerName;
    }

    public String getImageUrl() { return imageUrl; }
    public String getTitle() { return title; }
    public String getOwnerName() { return ownerName; }
}
