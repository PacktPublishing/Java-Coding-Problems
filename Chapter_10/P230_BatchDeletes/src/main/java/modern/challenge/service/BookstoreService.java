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
    public void batchAuthors() {
        List<Author> authors = authorRepository.findAll();
        //authorRepository.deleteAllInBatch();      // executing 0 JDBC batches
        //authorRepository.deleteInBatch(authors);  // executing 0 JDBC batches
        authors.forEach(authorRepository::delete);  // executing 3 JDBC batches
    }
}
