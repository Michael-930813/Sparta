package com.movie.service;

import com.movie.dto.*;
import com.movie.entity.Movie;
import com.movie.exception.MovieNotFoundException;
import com.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public CreateMovieResponse createMovie(CreateMovieRequest request) {
        Movie movie = new Movie(
                request.getTitle(),
                request.getEmail(),
                request.getPassword(),
                request.getPhoneNumber()
        );
        Movie savedMovie = movieRepository.save(movie);

        return new CreateMovieResponse(
                savedMovie.getId(),
                savedMovie.getTitle(),
                savedMovie.getEmail(),
                savedMovie.getPassword(),
                savedMovie.getPhoneNumber()
        );
    }

    @Transactional(readOnly = true)
    public GetMovieResponse findOne(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("없는 영화입니다.")
        );
        return new GetMovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getEmail(),
                movie.getPassword(),
                movie.getPhoneNumber()
        );
    }

    @Transactional(readOnly = true)
    public List<GetMovieResponse> findAll() {
        List<Movie> movies = movieRepository.findAll();

        List<GetMovieResponse> dtos = new ArrayList<>();
        for (Movie movie : movies) {
            dtos.add(
                    new GetMovieResponse(
                            movie.getId(),
                            movie.getTitle(),
                            movie.getEmail(),
                            movie.getPassword(),
                            movie.getPhoneNumber()
                    )
            );
        }
        return dtos;
    }

    @Transactional
    public UpdateMovieResponse update(Long movieId, UpdateMovieRequest request) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new MovieNotFoundException("없는 영화입니다.")
        );

        movie.update(
                request.getTitle(),
                request.getEmail(),
                request.getPassword(),
                request.getPhoneNumber()
        );
        return new UpdateMovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getEmail(),
                movie.getPassword(),
                movie.getPhoneNumber()
        );
    }

    @Transactional
    public void delete(Long movieId) {
        boolean existence = movieRepository.existsById(movieId);

        if (!existence) {
            throw new MovieNotFoundException("없는 영화입니다.");
        }

        movieRepository.deleteById(movieId);
    }
}
