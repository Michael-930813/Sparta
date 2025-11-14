package com.movie.dto;

import lombok.Getter;

@Getter
public class UpdateMovieResponse {

    private final Long id;
    private final String title;
    private final String email;
    private final String password;
    private final String phoneNumber;

    public UpdateMovieResponse(Long id, String title, String email, String password, String phoneNumber) {
        this.id = id;
        this.title = title;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
