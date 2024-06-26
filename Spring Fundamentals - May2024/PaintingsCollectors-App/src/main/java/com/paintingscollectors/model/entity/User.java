package com.paintingscollectors.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Email
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Painting> paintings;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Painting> favouritePaintings;

    @ManyToMany
    private Set<Painting> ratedPainting;

    public User() {
        this.paintings = new ArrayList<>();
        this.favouritePaintings = new HashSet<>();
        this.ratedPainting = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public List<Painting> getPaintings() {
        return paintings;
    }

    public void setPaintings(List<Painting> paintings) {
        this.paintings = paintings;
    }

    public Set<Painting> getFavouritePaintings() {
        return favouritePaintings;
    }

    public void setFavouritePaintings(Set<Painting> favouritePaintings) {
        this.favouritePaintings = favouritePaintings;
    }

    public Set<Painting> getRatedPainting() {
        return ratedPainting;
    }

    public void setRatedPainting(Set<Painting> ratedPainting) {
        this.ratedPainting = ratedPainting;
    }
}
