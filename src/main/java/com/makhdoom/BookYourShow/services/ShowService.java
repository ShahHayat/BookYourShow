package com.makhdoom.BookYourShow.services;

import com.makhdoom.BookYourShow.dtos.CreateShowRequestDTO;
import com.makhdoom.BookYourShow.enums.SeatStatus;
import com.makhdoom.BookYourShow.exceptions.AuditoriumNotFoundException;
import com.makhdoom.BookYourShow.exceptions.MovieNotFoundException;
import com.makhdoom.BookYourShow.exceptions.ShowNotFoundException;
import com.makhdoom.BookYourShow.models.*;
import com.makhdoom.BookYourShow.repositories.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowService {

    private ShowRepository showRepository;
    private AuditoriumService auditoriumService;
    private MovieService movieService;
    private SeatService seatService;
    private ShowSeatService showSeatService;

    public Show createShow(CreateShowRequestDTO request) {
        Auditorium auditorium = auditoriumService.getAuditoriumInternal(request.getAuditoriumId());
        if (auditorium == null) {
            throw new AuditoriumNotFoundException(request.getAuditoriumId());
        }
        Movie movie = movieService.getMovieInternal(request.getMovieId());
        if (movie == null) {
            throw new MovieNotFoundException(request.getAuditoriumId());
        }
        Show show = Show.builder()
                .auditorium(auditorium)
                .startTime(request.getStartTime())
                .duration(request.getDuration())
                .language(request.getLanguage())
                .build();

        Show savedShow = showRepository.save(show);

        List<Seat> seats = seatService.getAll(request.getAuditoriumId());
        List<ShowSeat> showSeats = seats.stream().map(
                seat -> ShowSeat.builder()
                        .seat(seat)
                        .show(show)
                        .status(SeatStatus.AVAILABLE)
                        .build()
        ).toList();

        List<ShowSeat> savedShowSeats = showSeatService.saveAll(showSeats);
        return showRepository.save(savedShow.toBuilder().showSeats(savedShowSeats).build());
    }

    public Show getShow(Long id) {
        return showRepository
                .findById(id)
                .orElseThrow(() -> new ShowNotFoundException(id));
    }
}
