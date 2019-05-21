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

    @Transactional
    public void registerAuthor() {

        Author author1 = new Author()
                .setId(1L)
                .setName("Name_1")
                .setSurname("Surname_1")
                .setAge(43)
                .addBook(new Book()
                        .setId(1L)
                        .setIsbn("Isbn_1")
                        .setTitle("Title_1"))
                .addBook(new Book()
                        .setId(2L)
                        .setIsbn("Isbn_2")
                        .setTitle("Title_2"));
        
        Author author2 = new Author()
                .id(2L)
                .name("Name_2")
                .surname("Surname_2")
                .age(51)
                .addBook(new Book()
                        .id(3L)
                        .isbn("Isbn_2")
                        .title("Title_2"))
                .addBook(new Book()
                        .id(4L)
                        .isbn("Isbn_3")
                        .title("Title_3"));

        authorRepository.save(author1);
        authorRepository.save(author2);
    }
    
    public void displayAuthors() {
        List<Author> authors = authorRepository.findAll();

        authors.forEach((a) -> logger.info(() -> "Author name: " + a.getName()));
    }

    @Transactional(readOnly=true)
    public void displayBooks() {
        List<Book> books = bookRepository.findAll();

        books.forEach((b) -> logger.info(() -> "Book title: " + b.getTitle()
                + " Author name: " + b.getAuthor().getName()));
    }
     
}
