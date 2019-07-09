package modern.challenge.service;

import java.util.List;
import modern.challenge.dto.BookDto;
import modern.challenge.entity.Book;
import org.springframework.stereotype.Service;
import modern.challenge.repository.BookRepository;
import modern.challenge.view.BookView;
import modern.challenge.view.BookViewDto;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookView fetchPage(long id, int limit) {
        List<Book> books = bookRepository.fetchPage(id, limit + 1);

        if (books.size() == (limit + 1)) {
            books.remove(books.size() - 1);
            return new BookView(books, false);
        }

        return new BookView(books, true);
    }

    public BookViewDto fetchPageDto(long id, int limit) {
        List<BookDto> books = bookRepository.fetchPageDto(id, limit + 1);

        if (books.size() == (limit + 1)) {
            books.remove(books.size() - 1);
            return new BookViewDto(books, false);
        }

        return new BookViewDto(books, true);
    }
}
