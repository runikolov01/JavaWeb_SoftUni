package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 20)
    @Column(unique = true, nullable = false)
    private String username;

    @Size(min = 3, max = 20)
    private String password;

    @Email
    private String email;

    @OneToMany(mappedBy = "addedBy")
    @Column(name = "added_words")
    private Set<Word> addedWords;

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @Size(min = 3, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@Size(min = 3, max = 20) String username) {
        this.username = username;
    }

    public @Size(min = 3, max = 20) String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 3, max = 20) String password) {
        this.password = password;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public Set<Word> getAddedWords() {
        return addedWords;
    }

    public void setAddedWords(Set<Word> addedWords) {
        this.addedWords = addedWords;
    }
}