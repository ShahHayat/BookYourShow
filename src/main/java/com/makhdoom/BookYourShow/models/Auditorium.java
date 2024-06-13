package com.makhdoom.BookYourShow.models;

import com.makhdoom.BookYourShow.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Auditorium extends BaseModel {

    private String name;

    @OneToMany
    private List<Seat> seats = new ArrayList<>();

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> features = new ArrayList<>();
}
