package com.makhdoom.BookYourShow.services;

import com.makhdoom.BookYourShow.exceptions.MovieAlreadyExistsException;
import com.makhdoom.BookYourShow.exceptions.MovieNotFoundException;
import com.makhdoom.BookYourShow.models.Movie;
import com.makhdoom.BookYourShow.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;

    public Movie getMovieInternal(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie getMovie(Long id) {
        return movieRepository
                .findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    public Movie createMovie(Movie movie) {
        Optional<Movie> existingMovie = movieRepository.findByName(movie.getName());
        if (existingMovie.isPresent()) {
            throw new MovieAlreadyExistsException(movie.getName());
        }
        return movieRepository.save(movie);
    }
}
