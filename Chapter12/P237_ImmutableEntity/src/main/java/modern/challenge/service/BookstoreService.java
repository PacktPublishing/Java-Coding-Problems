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

    public void newAuthor() {
        Author author = new Author();

        author.setId(1L);
        author.setName("Name");
        author.setSurname("Surname");
        author.setAge(23);

        authorRepository.save(author);
    }

    public void fetchAuthor() {
        Author author = authorRepository.findById(1L).orElseThrow();
        System.out.println(author);
    }

    @Transactional
    public void updateAuthor() {
        Author author = authorRepository.findById(1L).orElseThrow();
        author.setAge(45);
    }

    public void deleteAuthor() {
        authorRepository.deleteById(1L);
    }
}
