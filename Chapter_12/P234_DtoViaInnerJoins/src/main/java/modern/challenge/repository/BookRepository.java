package modern.challenge.repository;

import java.util.List;
import modern.challenge.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import modern.challenge.projection.AuthorNameBookTitle;

@Repository
@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book, Long> {

    // Books and authors (JPQL)
    @Query(value = "SELECT b.title as title, a.name as name "
            + "FROM Book b INNER JOIN b.author a")
    List<AuthorNameBookTitle> findBooksAndAuthorsJpql();

    // Books and authors (SQL)
    @Query(value = "SELECT b.title as title, a.name as name "
            + "FROM book b INNER JOIN author a ON a.id = b.author_id",
            nativeQuery = true)
    List<AuthorNameBookTitle> findBooksAndAuthorsSql();
}
