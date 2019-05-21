package modern.challenge.service;

import modern.challenge.repository.BookRepository;
import modern.challenge.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void insertTwoBooks() {

        Book book1 = new Book();
        book1.setTitle("Title_1");
        book1.setIsbn("Isbn_1");
        book1.setPrice(20);
        // book1.setSku(1L);

        Book book2 = new Book();
        book2.setTitle("Title_2");
        book2.setIsbn("Isbn_2");
        book2.setPrice(25);
        // book2.setSku(2L);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
    
    public void fetchOneBookByNaturalId() {
        Book book = (Book) bookRepository.findBySimpleNaturalId("Isbn_2").orElseThrow();

        System.out.println(book);
    }
}
