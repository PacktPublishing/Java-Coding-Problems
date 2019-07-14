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

    @Transactional
    public void neBookOfAuthor() {

        Author author = authorRepository.findById(1L).orElseThrow();

        Book book = new Book();
        book.setTitle("Title");
        book.setIsbn("Isbn");

        // this will set the id of the book as the id of the author
        book.setAuthor(author);

        bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public Book fetchBookByAuthorId() {

        Author author = authorRepository.findById(1L).orElseThrow();

        return bookRepository.findById(author.getId()).orElseThrow();
    }

}
