package io.github.burymydeadhoreses.library.services;

import io.github.burymydeadhoreses.library.exceptions.BookNotFoundException;
import io.github.burymydeadhoreses.library.models.Book;
import io.github.burymydeadhoreses.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository repository;

    @Autowired
    public BookService(final BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book getBook(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book createBook(Book book) {
        return repository.save(book);
    }

    public Book replaceBook(Book request, UUID id) {
        return repository.findById(id)
                .map(book -> {
                    book.setTitle(request.getTitle());
                    book.setAuthor(request.getAuthor());
                    return repository.save(book);
                })
                .orElseGet(() -> {
                    return repository.save(request);
                });
    }

    public void deleteBook(UUID id) {
        repository.deleteById(id);
    }
}
