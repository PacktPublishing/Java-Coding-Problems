package modern.challenge.service;

import modern.challenge.repository.BookRepository;
import java.util.List;
import modern.challenge.entity.Author;
import modern.challenge.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public void fetchAuthorsBooks() {

        List<Book> books = bookRepository.findAll();

        for (Book book : books) {
            Author author = book.getAuthor();
            System.out.println("Book: " + book.getTitle()
                    + ": Author: " + author.getName());
        }
    }
}
