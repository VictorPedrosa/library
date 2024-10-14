package com.store.library.domain.exception;

public class BookNotAvailableException extends RuntimeException {

    public BookNotAvailableException(Long id) {
        super("Book with ID " + id + " is not available to be borrowed.");
    }
}
