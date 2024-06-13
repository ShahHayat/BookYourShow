package com.makhdoom.BookYourShow.services;

import com.makhdoom.BookYourShow.dtos.CreateAuditoriumRequestDTO;
import com.makhdoom.BookYourShow.dtos.SeatPosition;
import com.makhdoom.BookYourShow.enums.SeatType;
import com.makhdoom.BookYourShow.models.Auditorium;
import com.makhdoom.BookYourShow.models.Seat;
import com.makhdoom.BookYourShow.repositories.AuditoriumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuditoriumService {

    private SeatService seatService;
    private AuditoriumRepository auditoriumRepository;

    public List<Seat> toSeats(Auditorium auditorium, Map<SeatType, List<SeatPosition>> seatPositions) {
        return seatPositions.entrySet().stream().flatMap(entry -> {

            SeatType seatType = entry.getKey();
            List<SeatPosition> positions = entry.getValue();

            return positions
                    .stream()
                    .map(seatPosition ->
                            Seat.builder()
                                    .seatType(seatType)
                                    .rowNumber(seatPosition.getRowNumber())
                                    .columnNumber(seatPosition.getColumnNumber())
                                    .auditorium(auditorium)
                                    .build());
        }).toList();
    }

    public Auditorium createAuditorium(CreateAuditoriumRequestDTO request) {
        Auditorium auditoriumRequest = Auditorium.builder()
                .name(request.getName())
                .features(request.getFeatures())
                .build();
        Auditorium initialAuditorium = auditoriumRepository.save(auditoriumRequest);

        List<Seat> seats = toSeats(initialAuditorium, request.getSeatRange());
        List<Seat> savedSeats = seatService.saveAll(seats);

        return auditoriumRepository.save(initialAuditorium.toBuilder().seats(savedSeats).build());
    }

    public Auditorium getAuditoriumInternal(Long id) {
        return auditoriumRepository.findById(id).orElse(null);
    }
}
