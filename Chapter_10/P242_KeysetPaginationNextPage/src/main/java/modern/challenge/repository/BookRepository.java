package modern.challenge.repository;

import java.util.List;
import modern.challenge.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM book AS b WHERE b.price > ?1 ORDER BY b.price ASC LIMIT ?2",
            nativeQuery = true)
    List<Book> fetchPage(long price, int limit);
}
