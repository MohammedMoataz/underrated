package com.odc.underrated.models;

import javax.persistence.*;

@Entity
@Table(name = "reels")
public class Reel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "caption")
    private String caption;

    @Column(name = "location")
    private String location;

    @Column(name = "likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reel() {
    }

    public Reel(String caption, String location, int likes, User user) {
        this.caption = caption;
        this.location = location;
        this.likes = likes;
        this.user = user;
    }

    public int getId() {
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
