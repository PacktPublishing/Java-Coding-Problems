package modern.challenge.service;

import modern.challenge.repository.AuthorRepository;
import modern.challenge.entity.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public void saveAndUpdateUser() {

        Author author = new Author();
        author.setName("Name_1");
        author.setSurname("Surname_1");
        author.setAge(25);

        authorRepository.save(author);

        author.setAge(35);
    }
}
