package com.odc.underrated.models;

import java.util.Set;

public class User {

    private long id;
    private String fullName;
    private String email;
    private String password;
    private String country;
    private Set<Reel> reels;

    public User() {
    }

    public User(String fullName, String email, String password, String country) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Reel> getReels() {
        return reels;
    }

    public void setReels(Set<Reel> reels) {
        this.reels = reels;
    }

}
