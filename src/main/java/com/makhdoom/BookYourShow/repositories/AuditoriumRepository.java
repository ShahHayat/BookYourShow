package com.makhdoom.BookYourShow.repositories;

import com.makhdoom.BookYourShow.models.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
}
