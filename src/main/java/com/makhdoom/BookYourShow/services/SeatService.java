package com.makhdoom.BookYourShow.services;

import com.makhdoom.BookYourShow.models.Seat;
import com.makhdoom.BookYourShow.repositories.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {

    private SeatRepository seatRepository;

    public List<Seat> getAll(Long auditoriumId) {
        return seatRepository.findAllByAuditorium_Id(auditoriumId);
    }

    public List<Seat> saveAll(List<Seat> seats) {
        return seatRepository.saveAll(seats);
    }
}
