package com.makhdoom.BookYourShow.models;

import com.makhdoom.BookYourShow.enums.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "shows")
public class Show extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private Date startTime;
    private Integer duration;

    @Enumerated
    private Language language;

    @ManyToOne
    private Auditorium auditorium;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;
}
