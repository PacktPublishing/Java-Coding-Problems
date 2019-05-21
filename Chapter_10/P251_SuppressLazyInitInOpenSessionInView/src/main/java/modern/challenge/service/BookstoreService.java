package modern.challenge.service;

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

    @Transactional(readOnly = true)
    public Author fetchAuthor() {
        Author author = authorRepository.findByName("Name_1");

        return author;
    }

}
