package com.store.library.infrastructure.rest;

import com.store.library.application.BookService;
import com.store.library.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> listAllBooks() {
        return ResponseEntity.ok(bookService.listAllBooks());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @PostMapping("/{bookId}/borrow")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.borrowBook(bookId));
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.returnBook(bookId));
    }

    @PostMapping("/{bookId}/remove")
    public ResponseEntity<Book> removeBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookService.removeBook(bookId));
    }

    @GetMapping("/borrowed")
    public ResponseEntity<List<Book>> listBorrowedBooks() {
        return ResponseEntity.ok(bookService.listBorrowedBooks());
    }
}
