package com.makhdoom.BookYourShow.services;

import com.makhdoom.BookYourShow.dtos.CreateBookingRequestDTO;
import com.makhdoom.BookYourShow.enums.BookingStatus;
import com.makhdoom.BookYourShow.enums.SeatStatus;
import com.makhdoom.BookYourShow.exceptions.AlreadyBookedException;
import com.makhdoom.BookYourShow.models.Booking;
import com.makhdoom.BookYourShow.models.Customer;
import com.makhdoom.BookYourShow.models.Show;
import com.makhdoom.BookYourShow.models.ShowSeat;
import com.makhdoom.BookYourShow.repositories.BookingRepository;
import com.makhdoom.BookYourShow.strategies.PricingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;
    private CustomerService customerService;
    private ShowService showService;
    private ShowSeatService showSeatService;

    private PricingStrategy pricingStrategy;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(CreateBookingRequestDTO request) {
        Customer customer = customerService.getCustomerInternal(request.getCustomerId());
        if (customer == null) {
            throw new NoSuchElementException("Customer with id: " + request.getCustomerId() + " does not exist");
        }

        Show show = showService.getShow(request.getShowId());
        if (show == null) {
            throw new NoSuchElementException("Show with id: " + request.getShowId() + " does not exist");
        }

        List<ShowSeat> showSeats = showSeatService.getShowSeats(request.getShowSeatIds());
        // TODO 1 - Filter and check size.
        // TODO 2 - Check if every element is available or not.
        for (ShowSeat showSeat : showSeats) {
            if (showSeat.getStatus() != SeatStatus.AVAILABLE) {
                throw new AlreadyBookedException(showSeat.getSeat().getId());
            }
        }

        List<ShowSeat> lockedShowSeats = showSeats.stream().map(
                showSeat -> showSeat.toBuilder()
                        .status(SeatStatus.LOCKED)
                        .build()
        ).toList();

        showSeatService.saveAll(lockedShowSeats);

        Booking booking = Booking.builder()
                .customer(customer)
                .show(show)
                .seats(lockedShowSeats)
                .status(BookingStatus.PENDING)
                .bookedAt(new Date())
                .build();

        Double amount = pricingStrategy.calculatePrice(booking);
        Booking bookingWithAmount = booking.toBuilder().amount(amount).build();

        return bookingRepository.save(bookingWithAmount);
    }
}
