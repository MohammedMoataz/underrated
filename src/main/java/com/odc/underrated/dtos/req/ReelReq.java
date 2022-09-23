package com.odc.underrated.dtos.req;

import java.time.LocalDate;

public class ReelReq {

    private String video;
    private String caption;
    private String location;
    private LocalDate date;
    private String userId;

    public ReelReq() {
    }

    public ReelReq(String video, String caption, String location, LocalDate date, String userId) {
        this.video = video;
        this.caption = caption;
        this.location = location;
        this.date = date;
        this.userId = userId;
    }

    public String getVideo() {
        return video;
    }

    public String getCaption() {
        return caption;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUserId() {
        return userId;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
