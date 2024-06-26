package com.paintingscollectors.model.dto;

import com.paintingscollectors.model.entity.StyleName;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Size;

public class AddPaintingDTO {
    @NotNull
    @Size(min = 5, max = 40)
    private String name;

    @NotNull
    @Size(min = 5, max = 30)
    private String author;

    @NotNull
    @Size(min = 1, max = 150)
    private String image;

    @NotNull
    private StyleName style;

    public AddPaintingDTO() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StyleName getStyle() {
        return style;
    }

    public void setStyle(StyleName style) {
        this.style = style;
    }
}