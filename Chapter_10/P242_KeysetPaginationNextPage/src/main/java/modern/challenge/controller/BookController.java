package modern.challenge.controller;

import modern.challenge.service.BookstoreService;
import modern.challenge.view.BookView;
import modern.challenge.view.BookViewDto;
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
    public BookView booksPage(@PathVariable long price, @PathVariable int limit) {

        return bookstoreService.fetchPage(price, limit);
    }

    @GetMapping("/dto/books/{price}/{limit}")
    public BookViewDto booksPageDto(@PathVariable long price, @PathVariable int limit) {

        return bookstoreService.fetchPageDto(price, limit);
    }

}
