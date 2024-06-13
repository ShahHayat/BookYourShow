package com.makhdoom.BookYourShow.models;

import com.makhdoom.BookYourShow.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Seat extends BaseModel {

    private Integer rowNumber;
    private Integer columnNumber;

    @Enumerated
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "auditorium_id")
    private Auditorium auditorium;
}
