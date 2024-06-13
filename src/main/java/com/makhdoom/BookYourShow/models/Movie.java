package com.makhdoom.BookYourShow.models;

import com.makhdoom.BookYourShow.enums.Language;
import com.makhdoom.BookYourShow.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Movie extends BaseModel {

    private String name;
    private Double rating;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Language> languages = new ArrayList<>();

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();
}
