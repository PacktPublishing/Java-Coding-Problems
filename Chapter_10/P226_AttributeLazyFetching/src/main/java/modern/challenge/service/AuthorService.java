package modern.challenge.service;

import modern.challenge.repository.AuthorRepository;
import modern.challenge.entity.Author;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void newAuthor() throws IOException {

        Author author = new Author();

        author.setId(1L);
        author.setName("Martinelli");
        author.setSurname("Jeko");
        author.setAge(24);

        // read the avatar from disk in a byte[]
        File file = new File("jeko.jpg");
        byte[] avatar = Files.readAllBytes(file.toPath());

        author.setAvatar(avatar);

        authorRepository.save(author);
    }

    public Author fetchAuthorWithoutAvatar() {

        return authorRepository.findById(1L).orElseThrow();
    }

    @Transactional(readOnly = true)
    public Author fetchAuthorWithAvatar() {

        Optional<Author> author = authorRepository.findById(1L);

        // this is lazy loaded in another query
        author.orElseThrow().getAvatar();

        return author.orElseThrow();
    }
}
