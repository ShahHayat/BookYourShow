package com.makhdoom.BookYourShow.dtos;

import com.makhdoom.BookYourShow.enums.Language;
import com.makhdoom.BookYourShow.enums.MovieFeature;
import com.makhdoom.BookYourShow.models.Movie;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateMovieRequestDTO {

    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<MovieFeature> features = new ArrayList<>();

    public Movie toMovie() {
        return Movie.builder()
                .name(name)
                .rating(rating)
                .languages(languages)
                .features(features)
                .build();
    }
}
