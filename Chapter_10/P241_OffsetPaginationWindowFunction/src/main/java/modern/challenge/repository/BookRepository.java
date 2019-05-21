package modern.challenge.repository;

import java.util.List;
import modern.challenge.dto.BookDto;
import modern.challenge.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {     
        
    @Query(value = "SELECT id, title, isbn, price, COUNT(*) OVER() AS total FROM book ORDER BY price LIMIT ?1, ?2",
            nativeQuery = true)
    List<BookDto> fetchPage(int page, int size);
}
