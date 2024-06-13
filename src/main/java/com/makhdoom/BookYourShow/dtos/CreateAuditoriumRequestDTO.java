package com.makhdoom.BookYourShow.dtos;

import com.makhdoom.BookYourShow.enums.MovieFeature;
import com.makhdoom.BookYourShow.enums.SeatType;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CreateAuditoriumRequestDTO {
    private String name;
    private List<MovieFeature> features = new ArrayList<>();
    private Map<SeatType, List<SeatPosition>> seatRange = new HashMap<>();
}
