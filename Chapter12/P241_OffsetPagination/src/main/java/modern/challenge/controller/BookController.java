package modern.challenge.controller;

import modern.challenge.entity.Book;
import modern.challenge.service.BookstoreService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookstoreService bookstoreService;

    public BookController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/books/{page}/{size}")
    public Page<Book> booksPage(@PathVariable int page, @PathVariable int size) {

        return bookstoreService.fetchPage(page, size);
    }

}
