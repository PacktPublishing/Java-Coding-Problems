package modern.challenge.repository;

import modern.challenge.naturalid.NaturalRepository;
import modern.challenge.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository<T, ID> extends NaturalRepository<Book, Long>{    
}
