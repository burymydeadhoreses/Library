package io.github.burymydeadhoreses.library;

import io.github.burymydeadhoreses.library.models.Book;
import io.github.burymydeadhoreses.library.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class LoadDatabase {


    @Configuration
    static
    class LoadDB {

        private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

        @Bean
        CommandLineRunner initDatabase(BookRepository repository) {

            return args -> {
                log.info("Preloading {}", repository.save(new Book("Fallout: Equestria", "Kkat")));
                log.info("Preloading {}", repository.save(new Book("Fallout: Equestria - Project Horizons", "Somber")));
            };
        }
    }
}
