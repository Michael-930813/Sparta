package com.movie.exception;

import org.springframework.http.HttpStatus;

public class MovieNotFoundException extends ServerException{
    public MovieNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
