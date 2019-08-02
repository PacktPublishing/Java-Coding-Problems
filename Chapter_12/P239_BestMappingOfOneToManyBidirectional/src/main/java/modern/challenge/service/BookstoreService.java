package modern.challenge.service;

import java.util.List;
import modern.challenge.repository.BookRepository;
import modern.challenge.repository.AuthorRepository;
import java.util.logging.Logger;
import modern.challenge.entity.Author;
import modern.challenge.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private static final Logger logger
            = Logger.getLogger(BookstoreService.class.getName());

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookstoreService(AuthorRepository authorRepository,
            BookRepository bookRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void registerAuthor() {

        Author author = new Author();        
        author.setName("Name_1");
        author.setSurname("Surname_1");
        author.setAge(43);

        Book book1 = new Book();        
        book1.setIsbn("Isbn_1");
        book1.setTitle("Title_1");

        Book book2 = new Book();       
        book2.setIsbn("Isbn_2");
        book2.setTitle("Title_2");

        author.addBook(book1);
        author.addBook(book2);

        authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    public void displayAuthors() {
        List<Author> authors = authorRepository.findAll();

        authors.forEach((a) -> logger.info(() -> "Author name: " + a.getName()
                + " Books: " + a.getBooks()));
    }

    @Transactional(readOnly = true)
    public void displayBooks() {
        List<Book> books = bookRepository.findAll();

        books.forEach((b) -> logger.info(() -> "Book title: " + b.getTitle()
                + " Author name: " + b.getAuthor().getName()));
    }

}
