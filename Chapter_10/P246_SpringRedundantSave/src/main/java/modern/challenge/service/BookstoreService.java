package modern.challenge.service;

import modern.challenge.entity.Book;
import modern.challenge.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void updateBookPriceViaRedundantSave() {
        Book book = bookRepository.findById(1L).get();

        book.setPrice(book.getPrice() - 5);
        bookRepository.save(book);
    }

    @Transactional
    public void updateBookPriceRecommended() {
        Book book = bookRepository.findById(1L).get();

        book.setPrice(book.getPrice() - 5);
    }
}
