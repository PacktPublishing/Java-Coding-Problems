package modern.challenge.service;

import java.util.List;
import modern.challenge.dto.BookDto;
import org.springframework.stereotype.Service;
import modern.challenge.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<BookDto> fetchPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, new Sort(Sort.Direction.ASC, "price"));

        List<BookDto> authors = bookRepository.fetchPage(pageable);
        Page<BookDto> pageOfAuthors = new PageImpl(authors, pageable,
                authors.isEmpty() ? 0 : authors.get(0).getTotal());

        return pageOfAuthors;
    }
}
