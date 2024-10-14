package com.store.library.domain.exception;

public class BookNotBorrowedException extends RuntimeException {

    public BookNotBorrowedException(Long id) {
        super("Book with ID " + id + " is not borrowed.");
    }
}
