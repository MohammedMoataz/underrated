package com.odc.underrated.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "likes",
            joinColumns = {@JoinColumn(name = "reel_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private final Set<User> likedUsers = new HashSet<>();

    public Reel() {
        this.id = UUID.randomUUID().toString();
    }

    public Reel(String video, String caption, String location, LocalDate date, User user) {
        this.id = UUID.randomUUID().toString();
        this.video = video;
        this.caption = caption;
        this.location = location;
        this.date = date;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getVideo() {
        return video;
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

    public User getUser() {
        return user;
    }

    public Set<User> getLikedUsers() {
        return likedUsers;
    }
}
