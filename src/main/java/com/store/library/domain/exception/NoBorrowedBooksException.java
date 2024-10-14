package com.store.library.domain.exception;

public class NoBorrowedBooksException extends RuntimeException {

    public NoBorrowedBooksException() {
        super("All books are available.");
    }
}
