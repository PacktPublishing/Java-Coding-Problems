package modern.challenge.repository;

import java.util.Optional;
import modern.challenge.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {  
    
    @Transactional(readOnly=true)
    Optional<Book> findByTitle(String title);
}
