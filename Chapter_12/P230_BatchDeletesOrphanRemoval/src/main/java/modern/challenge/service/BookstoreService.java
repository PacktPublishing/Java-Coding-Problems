package modern.challenge.service;

import java.util.List;
import modern.challenge.entity.Author;
import modern.challenge.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public void batchAuthorsAndBooks() {
        List<Author> authors = authorRepository.fetchAll();

        authors.forEach(Author::removeBooks);
        authorRepository.flush();

        authors.forEach(authorRepository::delete);
    }
}
