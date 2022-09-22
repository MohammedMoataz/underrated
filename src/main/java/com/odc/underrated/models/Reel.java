package com.odc.underrated.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "reels")
public class Reel {

    @Id
    @Column(name = "id")
    private final String id;
    @Column(name = "video")
    private String video;
    @Column(name = "caption")
    private String caption;
    @Column(name = "location")
    private String location;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "likes")
    private int likes;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reel() {
        this.id = UUID.randomUUID().toString();
    }

    public Reel(String video, String caption, String location, LocalDate date, int likes, User user) {
        this.id = UUID.randomUUID().toString();
        this.video = video;
        this.caption = caption;
        this.location = location;
        this.date = date;
        this.likes = likes;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
