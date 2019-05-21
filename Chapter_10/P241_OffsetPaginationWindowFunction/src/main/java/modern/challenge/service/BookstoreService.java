package modern.challenge.service;

import java.util.List;
import modern.challenge.dto.BookDto;
import org.springframework.stereotype.Service;
import modern.challenge.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public List<BookDto> fetchPage(int page, int size) {

        return bookRepository.fetchPage(page, size);
    }
}
