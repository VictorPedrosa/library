package com.store.library.domain.service;

import com.store.library.application.BookService;
import com.store.library.domain.exception.*;
import com.store.library.domain.model.Book;
import com.store.library.infrastructure.persistence.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public Book addBook(Book book) {
        if (bookRepository.existsByAuthorAndTitle(book.getAuthor(), book.getTitle())){
            throw new BookAlreadyExistsException(book.getAuthor(), book.getTitle());
        } else {
            return bookRepository.save(book);
        }
    }

    public Book borrowBook(Long bookId) {
        Book book = getBook(bookId);
        if (!book.isBorrowed()){
            book.setBorrowed(true);
            return bookRepository.save(book);
        } else {
            throw new BookNotAvailableException(bookId);
        }
    }

    public Book returnBook(Long bookId) {
        Book book = getBook(bookId);
        if (book.isBorrowed()){
            book.setBorrowed(false);
            return bookRepository.save(book);
        } else {
            throw new BookNotBorrowedException(bookId);
        }
    }

    public Book removeBook(Long bookId) {
        Book book = getBook(bookId);
        bookRepository.deleteById(bookId);
        return book;
    }

    public List<Book> listAllBooks() {
        List<Book> booksRegistered = bookRepository.findAll();

        if (!booksRegistered.isEmpty()) {
            return booksRegistered;
        } else {
            throw new NoRegisteredBooksException();
        }
    }

    public List<Book> listBorrowedBooks() {
        List<Book> borrowedBooks =  bookRepository.findAll().stream()
            .filter(Book::isBorrowed)
            .collect(Collectors.toList());

        if (!borrowedBooks.isEmpty()) {
            return borrowedBooks;
        } else {
            throw new NoBorrowedBooksException();
        }
    }

    private Book getBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
    }
}
