package com.odc.underrated.models;

import java.time.LocalDate;

public class Reel {

    private Long id;
    private byte[] video;
    private String caption;
    private String location;
    private LocalDate date;
    private int likes;
    private User user;

    public Reel() {
    }

    public Reel(byte[] video, String caption, String location, int likes, User user) {
        this.video = video;
        this.caption = caption;
        this.location = location;
        this.likes = likes;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
