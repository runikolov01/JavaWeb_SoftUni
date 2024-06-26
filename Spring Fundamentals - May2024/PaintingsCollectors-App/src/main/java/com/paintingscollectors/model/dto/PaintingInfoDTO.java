package com.paintingscollectors.model.dto;

import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.StyleName;
import com.paintingscollectors.model.entity.User;

import javax.persistence.Column;
import javax.validation.constraints.Max;

public class PaintingInfoDTO {
    @Column(nullable = false)
    private Long id;

    @Max(150)
    private String imageUrl;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private StyleName style;

    public PaintingInfoDTO(Painting painting) {
        this.id = painting.getId();
        this.imageUrl = painting.getImageUrl();
        this.name = painting.getName();
        this.author = painting.getAuthor();
        this.style = painting.getStyle().getStyle();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public StyleName getStyle() {
        return style;
    }

    public void setStyle(StyleName style) {
        this.style = style;
    }
}