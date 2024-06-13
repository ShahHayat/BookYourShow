package com.makhdoom.BookYourShow.repositories;

import com.makhdoom.BookYourShow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Optional<Movie> findByName(String name);
}
