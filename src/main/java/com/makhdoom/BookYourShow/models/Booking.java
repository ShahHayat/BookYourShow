package com.makhdoom.BookYourShow.models;

import com.makhdoom.BookYourShow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Booking extends BaseModel {

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;
    private Date bookedAt;

    @Enumerated
    private BookingStatus status;

    @OneToMany
    private List<Payment> payments;
}
