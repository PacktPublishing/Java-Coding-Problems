package modern.challenge.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import modern.challenge.entity.Book;
import org.springframework.stereotype.Service;
import modern.challenge.repository.BookRepository;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Map<List<Book>, Boolean> fetchPage(long price, int limit) {
        List<Book> books = bookRepository.fetchPage(price, limit + 1);

        if (books.size() == (limit + 1)) {
            books.remove(books.size() - 1);
            return Collections.singletonMap(books, true);
        }

        return Collections.singletonMap(books, false);
    }
}
