package modern.challenge.controller;

import java.util.List;
import modern.challenge.dto.BookDto;
import modern.challenge.service.BookstoreService;
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
    public List<BookDto> booksPage(@PathVariable int page, @PathVariable int size) {

        return bookstoreService.fetchPage(page, size);
    }

}
