package modern.challenge.service;

import java.util.List;
import modern.challenge.entity.Author;
import modern.challenge.entity.Book;
import modern.challenge.repository.AuthorRepository;
import modern.challenge.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookstoreService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void batchAuthorsAndBooks() {

        List<Book> books = bookRepository.findAll();

        for (Book book : books) {
            book.setIsbn("-1");

            Author author = book.getAuthor();
            author.setAge(-1);
        }

        // or
        /*
        List<Author> authors = authorRepository.findAll();
        
        for (Author author : authors) {            
            author.setAge(-1);
            for (Book book : author.getBooks()) {
                book.setIsbn("-1");
            }
        }
         */
    }
}
