package com.store.library.domain.exception;

public class NoRegisteredBooksException extends RuntimeException {

    public NoRegisteredBooksException() {
        super("The library is empty.");
    }
}
