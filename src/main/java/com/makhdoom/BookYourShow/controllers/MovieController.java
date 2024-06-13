package com.makhdoom.BookYourShow.controllers;

import com.makhdoom.BookYourShow.dtos.CreateMovieRequestDTO;
import com.makhdoom.BookYourShow.models.Movie;
import com.makhdoom.BookYourShow.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @PostMapping("")
    public Movie createMovie(@RequestBody CreateMovieRequestDTO request) {
        return movieService.createMovie(request.toMovie());
    }
}
