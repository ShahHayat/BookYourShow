package com.makhdoom.BookYourShow.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateBookingRequestDTO {
    private Long customerId;
    private Long showId;
    private List<Long> showSeatIds = new ArrayList<>();
}
