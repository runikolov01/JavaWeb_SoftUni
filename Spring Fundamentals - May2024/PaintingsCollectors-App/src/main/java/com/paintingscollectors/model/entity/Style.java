package com.paintingscollectors.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private StyleName style;

    @Column(nullable = false)
    private String description;

    public Style() {
    }

    public Style(StyleName style, String description) {
        this();

        this.style = style;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StyleName getStyle() {
        return style;
    }

    public void setStyleName(StyleName style) {
        this.style = style;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}