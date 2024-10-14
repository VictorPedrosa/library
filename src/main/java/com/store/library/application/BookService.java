package com.store.library.application;

import com.store.library.domain.model.Book;


import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book borrowBook(Long bookId);
    Book returnBook(Long bookId);
    Book removeBook(Long bookId);
    List<Book> listBorrowedBooks();
    List<Book> listAllBooks();
}
