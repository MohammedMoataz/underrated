package com.odc.underrated.dtos.res;

import java.time.LocalDate;

public class ReelRes {

    private final String id;
    private String video;
    private String caption;
    private String location;
    private LocalDate date;
    private int likes;
    private UserRes creator;

    public ReelRes(String id, String video, String caption, String location, LocalDate date, int likes, UserRes creator) {
        this.id = id;
        this.video = video;
        this.caption = caption;
        this.location = location;
        this.date = date;
        this.likes = likes;
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
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

    public UserRes getUserRes() {
        return creator;
    }

    public void setUserRes(UserRes creator) {
        this.creator = creator;
    }
}
