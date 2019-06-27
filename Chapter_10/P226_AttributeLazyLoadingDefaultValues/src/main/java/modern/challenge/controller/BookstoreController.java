package modern.challenge.controller;

import modern.challenge.service.BookstoreService;
import modern.challenge.entity.Author;
import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/create")
    public String create() throws IOException {

        bookstoreService.createAuthors();

        return "created";
    }

    @GetMapping("/author/{id}")
    public Author fetchAuthor(@PathVariable long id) {
        return bookstoreService.fetchAuthor(id);
    }
}
