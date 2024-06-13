package com.makhdoom.BookYourShow.repositories;

import com.makhdoom.BookYourShow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    public List<ShowSeat> findAllByShow_AuditoriumId(Long id);
}
