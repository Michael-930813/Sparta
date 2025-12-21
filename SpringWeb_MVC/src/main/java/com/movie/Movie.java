package com.movie;

import lombok.Getter;

@Getter
public class Movie {
    private String title;
    private String imageUrl;
    
    public Movie(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }
}