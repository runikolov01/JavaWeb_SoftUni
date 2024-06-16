package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "words")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Size(min = 2, max = 40)
    private String term;

    @Column(nullable = false)
    @Size(min = 2, max = 80)
    private String translation;

    @Size(min = 2, max = 200)
    private String example;

    @Column(name = "input_date", nullable = false)
    private LocalDate inputDate;

    @ManyToOne(optional = false)
    private Language language;

    @ManyToOne(optional = false)
    private User addedBy;

    public Word() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @Size(min = 2, max = 40) String getTerm() {
        return term;
    }

    public void setTerm(@Size(min = 2, max = 40) String term) {
        this.term = term;
    }

    public @Size(min = 2, max = 80) String getTranslation() {
        return translation;
    }

    public void setTranslation(@Size(min = 2, max = 80) String translation) {
        this.translation = translation;
    }

    public @Size(min = 2, max = 200) String getExample() {
        return example;
    }

    public void setExample(@Size(min = 2, max = 200) String example) {
        this.example = example;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }
}