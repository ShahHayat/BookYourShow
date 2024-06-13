package com.makhdoom.BookYourShow.strategies;

import com.makhdoom.BookYourShow.models.Booking;

public interface PricingStrategy {
    Double calculatePrice(Booking booking);
}
