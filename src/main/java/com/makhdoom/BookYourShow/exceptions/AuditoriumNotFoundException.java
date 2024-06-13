package com.makhdoom.BookYourShow.exceptions;

public class AuditoriumNotFoundException extends RuntimeException {
    public AuditoriumNotFoundException(Long auditoriumId) {
        super("Auditorium with id: " + auditoriumId + " does not exist");
    }
}
