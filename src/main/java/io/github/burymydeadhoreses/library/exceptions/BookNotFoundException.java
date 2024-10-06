package io.github.burymydeadhoreses.library.exceptions;

import java.util.UUID;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(UUID id) {
        super("Could not find book " + id);
    }
}