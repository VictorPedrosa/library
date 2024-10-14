package com.store.library.domain.exception;

public class BookAlreadyExistsException extends RuntimeException {

    public BookAlreadyExistsException(String author, String title) {
        super("The book " + title + " written by " + author + " is already registered at the library.");
    }
}
