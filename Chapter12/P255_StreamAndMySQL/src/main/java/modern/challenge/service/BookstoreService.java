package modern.challenge.service;

import java.util.ArrayList;
import java.util.List;
import modern.challenge.repository.AuthorRepository;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import modern.challenge.entity.Author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void populateDatabase() {
        List<Author> authors = new ArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            Author author = new Author();
            author.setName("Name_" + i);
            author.setSurname("Surname_" + i);
            author.setAge((int) (Math.random() * 10 + 18));

            authors.add(author);
        }

        authorRepository.saveAll(authors);
    }

    @Transactional(readOnly = true)
    public void streamDatabase() {

        long startTime = System.nanoTime();
        try ( Stream<Author> authorStream = authorRepository.streamAll()) {

            authorStream.forEach(System.out::println);
        }
        System.out.println("Total time: "
                + TimeUnit.MILLISECONDS.convert((System.nanoTime() - startTime),
                        TimeUnit.NANOSECONDS) + " ms");
    }

}
