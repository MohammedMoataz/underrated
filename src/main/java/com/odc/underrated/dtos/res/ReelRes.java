package com.odc.underrated.dtos.res;

import java.time.LocalDate;
import java.util.Set;

public class ReelRes {

    private String id;
    private String video;
    private String caption;
    private String location;
    private LocalDate date;
    private UserRes creator;

    public ReelRes() {
    }

    public ReelRes(String id, String video, String caption, String location, LocalDate date, UserRes creator) {
        this.id = id;
        this.video = video;
        this.caption = caption;
        this.location = location;
        this.date = date;
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public UserRes getCreator() {
        return creator;
    }

    public void setCreator(UserRes creator) {
        this.creator = creator;
    }
}
