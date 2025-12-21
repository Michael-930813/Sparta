package com.movie.controller;

import com.movie.dto.*;
import com.movie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<CreateMovieResponse> createMovie(
            @Valid @RequestBody CreateMovieRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(request));
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<GetMovieResponse> getMovie(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findOne(movieId));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<GetMovieResponse>> getMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAll());
    }

    @PutMapping("/movies/{movieId}")
    public ResponseEntity<UpdateMovieResponse> updateMovie(
            @PathVariable Long movieId,
            @Valid @RequestBody UpdateMovieRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.update(movieId, request));
    }

    @DeleteMapping("/movies/{movieId}")
    public ResponseEntity<Void> deleteMovie(
            @PathVariable Long movieId
    ) {
        movieService.delete(movieId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
