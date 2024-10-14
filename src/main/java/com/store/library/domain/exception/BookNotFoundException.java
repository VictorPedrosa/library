package com.store.library.domain.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("Book with ID " + id + " not found.");
    }
}
