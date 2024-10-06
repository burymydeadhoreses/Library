package io.github.burymydeadhoreses.library.controllers;

import io.github.burymydeadhoreses.library.models.Book;
import io.github.burymydeadhoreses.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController {
    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/get-books")
    List<Book> getAllBooks() {
        return service.getBooks();
    }

    @GetMapping("/get-book/{id}")
    Book getBook(@PathVariable UUID id) {
        return service.getBook(id);
    }

    @PostMapping("/create-book")
    Book createBook(@RequestBody Book book) {
        return service.createBook(book);
    }

    @PutMapping("/replace-book/{id}")
    Book replaceBook(@RequestBody Book book, @PathVariable UUID id) {
        return service.replaceBook(book, id);
    }

    @DeleteMapping("/delete-book/{id}")
    void deleteBook(@PathVariable UUID id) {
        service.deleteBook(id);
    }
}
