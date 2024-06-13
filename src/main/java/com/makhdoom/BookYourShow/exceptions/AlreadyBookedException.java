package com.makhdoom.BookYourShow.exceptions;

public class AlreadyBookedException extends RuntimeException {
    public AlreadyBookedException(Long id) {
        super("Seat with id: " + id + ", is not available");
    }
}
