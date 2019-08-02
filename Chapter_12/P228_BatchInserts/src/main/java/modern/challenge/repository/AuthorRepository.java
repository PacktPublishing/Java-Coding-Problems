package modern.challenge.repository;

import modern.challenge.impl.BatchRepository;
import modern.challenge.entity.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends BatchRepository<Author, Long> {        
}

