package com.movie.config;

import com.movie.exception.ServerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // - MovieNotFoundException Custom Error Handle
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<String> handleServiceException(ServerException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(ex.getMessage());
    }
}
