package com.makhdoom.BookYourShow.repositories;

import com.makhdoom.BookYourShow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
