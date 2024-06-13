package com.makhdoom.BookYourShow.exceptions;

public class InvalidCustomerException extends RuntimeException {
    public InvalidCustomerException() {
        super("Email is mandatory.");
    }
}
