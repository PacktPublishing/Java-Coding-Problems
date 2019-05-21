package modern.challenge.controller;

import modern.challenge.service.BookstoreService;
import java.util.List;
import java.util.Map;
import modern.challenge.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookstoreService bookstoreService;

    public BookController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/books/{price}/{limit}")
    public Map<List<Book>, Boolean> booksPage(@PathVariable long price, @PathVariable int limit) {

        return bookstoreService.fetchPage(price, limit);
    }

}
