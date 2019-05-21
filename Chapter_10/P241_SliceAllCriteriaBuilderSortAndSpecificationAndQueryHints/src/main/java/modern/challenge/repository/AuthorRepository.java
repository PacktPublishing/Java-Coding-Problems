package modern.challenge.repository;

import modern.challenge.repository.impl.SlicePagingRepositoryImplementation;
import org.springframework.stereotype.Repository;
import modern.challenge.entity.Author;

@Repository
public class AuthorRepository extends SlicePagingRepositoryImplementation<Author> {

    public AuthorRepository() {
        super(Author.class);
    }
}
