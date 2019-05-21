package modern.challenge;

import modern.challenge.repository.AuthorRepository;
import modern.challenge.repository.BookRepository;
import modern.challenge.entity.Author;
import modern.challenge.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookstoreService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void newBook() {

        Book book = new Book();
        book.setIsbn("Isbn");
        book.setTitle("Title");

        bookRepository.save(book);
    }

    @Transactional
    public void newAuthorOfBook() {

        Book book = bookRepository.findByTitle("Title");

        Author author = new Author();
        author.setName("Name");
        author.setSurname("Surname");
        author.setAge(40);
        author.setBook(book); // this will set the ID of author as the ID of the book

        authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    public Author findAuthorOfBook() {

        Book book = bookRepository.findByTitle("Title");

        return authorRepository.findById(book.getId()).orElseThrow();
    }
}
