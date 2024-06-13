package com.makhdoom.BookYourShow.controllers;

import com.makhdoom.BookYourShow.dtos.CreateBookingRequestDTO;
import com.makhdoom.BookYourShow.models.Booking;
import com.makhdoom.BookYourShow.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boooking")
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(CreateBookingRequestDTO request) {
        return bookingService.createBooking(request);
    }
}
