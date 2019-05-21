package modern.challenge.service;

import modern.challenge.repository.AuthorRepository;
import java.util.List;
import modern.challenge.entity.Author;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void fetchAuthorsLeftJoinBooksWithDuplicates() {
        System.out.println("Fetching authors and books with duplicates ...");

        List<Author> authors
                = authorRepository.fetchAuthorsLeftJoinBooksWithDuplicates();

        authors.forEach((t) -> {
            System.out.println("Author name: " + t.getName() + ", Books: " + t.getBooks());
        });
    }

    public void fetchAuthorsLeftJoinBooksWithoutHint() {
        System.out.println("Fetching authors and books without the HINT_PASS_DISTINCT_THROUGH hint ...");

        List<Author> authors
                = authorRepository.fetchAuthorsLeftJoinBooksWithoutHint();

        authors.forEach((t) -> {
            System.out.println("Author name: " + t.getName() + ", Books: " + t.getBooks());
        });
    }

    public void fetchAuthorsLeftJoinBooksWithHint() {
        System.out.println("Fetching authors and books with the HINT_PASS_DISTINCT_THROUGH hint ...");

        List<Author> authors
                = authorRepository.fetchAuthorsLeftJoinBooksWithHint();

        authors.forEach((t) -> {
            System.out.println("Author name: " + t.getName() + ", Books: " + t.getBooks());
        });
    }
}
