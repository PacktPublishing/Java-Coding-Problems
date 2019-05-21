package modern.challenge.repository;

import java.time.Instant;
import modern.challenge.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    @Query(value = "select concat_ws(b.title, ?1, b.price, ?2) from Book b WHERE b.id = 1")
    String fetchBookNamePrice(String symbol, Instant instant);
}
