package com.makhdoom.BookYourShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {

    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany
    private List<Auditorium> auditoriums = new ArrayList<>();

    @OneToMany
    private List<Show> shows = new ArrayList<>();
}
