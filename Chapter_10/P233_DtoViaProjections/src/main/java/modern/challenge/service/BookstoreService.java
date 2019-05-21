package modern.challenge.service;

import java.util.List;
import modern.challenge.projection.AuthorNameAge;
import modern.challenge.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;

    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorNameAge> fetchFirst2ByBirthplace() {

        return authorRepository.findFirst2ByBirthplace("Birthplace_1");
    }
}
