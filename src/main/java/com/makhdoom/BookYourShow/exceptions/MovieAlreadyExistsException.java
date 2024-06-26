package com.makhdoom.BookYourShow.exceptions;

public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(String name) {
        super("Movie with name: " + name + " already exists");
    }
}
