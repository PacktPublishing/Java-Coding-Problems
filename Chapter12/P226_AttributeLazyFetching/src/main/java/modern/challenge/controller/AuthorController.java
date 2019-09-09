package modern.challenge.controller;

import modern.challenge.entity.Author;
import java.io.IOException;
import modern.challenge.service.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/new")
    public String newUser() throws IOException {

        authorService.newAuthor();

        return "ok";
    }

    @RequestMapping("/author")
    public Author fetchUser() {

        Author author = authorService.fetchAuthorWithoutAvatar();        
        
        return author;
    }

    @RequestMapping("/avatar")
    public Author fetchAvatar() {

        return authorService.fetchAuthorWithAvatar();
    }
}
