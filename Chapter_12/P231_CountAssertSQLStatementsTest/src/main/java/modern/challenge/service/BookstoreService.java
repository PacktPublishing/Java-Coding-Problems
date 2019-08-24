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

    public void withoutTransactional() {
        Author author = new Author();

        author.setName("Name_1");
        author.setSurname("Surname_1");
        author.setAge(45);

        authorRepository.save(author);      // 1 insert
        author.setAge(55);
        authorRepository.save(author);      // 1 select and 1 update
        authorRepository.delete(author);    // 1 select and 1 delete       
    }

    @Transactional
    public void withTransactional() {
        Author author = new Author();

        author.setName("Name_1");
        author.setSurname("Surname_1");
        author.setAge(45);

        authorRepository.save(author);      // 1 insert
        author.setAge(55);
        authorRepository.save(author);      // update not triggered since a delete follows
        authorRepository.delete(author);    // 1 delete        
    }
}
