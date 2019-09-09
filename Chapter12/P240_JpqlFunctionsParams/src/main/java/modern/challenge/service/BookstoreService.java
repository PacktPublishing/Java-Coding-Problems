package modern.challenge.service;

import modern.challenge.repository.BookRepository;
import java.time.Instant;
import modern.challenge.dao.Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final Dao dao;
    private final BookRepository bookRepository;

    public BookstoreService(Dao dao, BookRepository bookRepository) {
        this.dao = dao;
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public String fetchBookNamePriceViaRepo() {
        return bookRepository.fetchBookNamePrice("$", Instant.now());
    }

    public String fetchBookNamePriceViaEM() {
        return dao.fetchBookNamePrice("$", Instant.now());
    }
}
