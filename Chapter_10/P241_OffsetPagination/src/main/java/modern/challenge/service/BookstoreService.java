package modern.challenge.service;

import modern.challenge.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import modern.challenge.repository.BookRepository;
import org.springframework.data.domain.Sort;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<Book> fetchPage(int page, int size) {

        return bookRepository.findAll(PageRequest.of(page, size, new Sort(Sort.Direction.ASC, "price")));
    }
}
