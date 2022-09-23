package com.odc.underrated.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private final String id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "user")
    private final Set<Reel> reels = new HashSet<>();

    @ManyToMany(mappedBy = "likedUsers")
    private final Set<Reel> likedReels = new HashSet<>();


    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String name, String email, String password, String country) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Reel> getLikedReels() {
        return likedReels;
    }
}
