package com.odc.underrated.models;

public class Reel {

    private long id;
    private String caption;
    private String location;
    private int likes;
    private User user;
    public Reel() {
    }

    public Reel(String caption, String location, int likes, User user) {
        this.caption = caption;
        this.location = location;
        this.likes = likes;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public User getCreator() {
        return user;
    }

    public void setCreator(User user) {
        this.user = user;
    }

}
