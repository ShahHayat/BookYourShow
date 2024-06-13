package com.makhdoom.BookYourShow.strategies;

import com.makhdoom.BookYourShow.enums.SeatType;
import com.makhdoom.BookYourShow.models.Booking;
import org.springframework.stereotype.Component;

// TODO 1 : Create another strategy like movie, theatre, feature

@Component
public class SeatBasedPricingStrategy implements PricingStrategy {

    // TODO 2 : Move this to database as it violates OCP
    // (theatre_id, seat_type) => price
    private Double getPrice(SeatType seatType) {
        switch (seatType) {
            case SILVER -> {
                return 250.0;
            }
            case GOLD -> {
                return 500.0;
            }
            case PLATINUM -> {
                return 1000.0;
            }
            case VIP -> {
                return 2000.0;
            }
        };

        throw new IllegalArgumentException("Invalid seat type: " + seatType);
    }

    @Override
    public Double calculatePrice(Booking booking) {
        return booking.getSeats().stream().mapToDouble(
                seat -> getPrice(seat.getSeat().getSeatType())
        ).sum();
    }
}
