package com.makhdoom.BookYourShow.exceptions;

public class ShowNotFoundException extends RuntimeException {
    public ShowNotFoundException(Long id) {
        super("Show with id: " + id + " does not exist");
    }
}
