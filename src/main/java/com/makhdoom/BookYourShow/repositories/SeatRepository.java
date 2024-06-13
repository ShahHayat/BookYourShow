package com.makhdoom.BookYourShow.repositories;

import com.makhdoom.BookYourShow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    public List<Seat> findAllByAuditorium_Id(Long id);
}
