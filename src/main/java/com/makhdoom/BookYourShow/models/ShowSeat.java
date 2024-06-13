package com.makhdoom.BookYourShow.models;

import com.makhdoom.BookYourShow.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class ShowSeat extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated
    private SeatStatus status;
}
