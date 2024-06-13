package com.makhdoom.BookYourShow.dtos;

import com.makhdoom.BookYourShow.enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class CreateShowRequestDTO {
    private Long auditoriumId;
    private Long movieId;
    private Date startTime;
    private Integer duration;
    private Language language;
}
