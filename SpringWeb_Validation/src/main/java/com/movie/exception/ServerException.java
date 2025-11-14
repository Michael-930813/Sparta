package com.movie.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServerException extends RuntimeException {
    private final HttpStatus status;

    public ServerException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
