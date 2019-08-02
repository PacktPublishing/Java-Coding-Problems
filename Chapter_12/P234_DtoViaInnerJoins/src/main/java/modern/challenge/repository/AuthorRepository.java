package modern.challenge.repository;

import java.util.List;
import modern.challenge.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import modern.challenge.projection.AuthorNameBookTitle;

@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Authors and books (JPQL)    
    @Query(value = "SELECT b.title as title, a.name as name "
            + "FROM Author a INNER JOIN a.books b")
    List<AuthorNameBookTitle> findAuthorsAndBooksJpql();

    // Authors and books (SQL)
    @Query(value = "SELECT b.title as title, a.name as name "
            + "FROM author a INNER JOIN book b ON a.id = b.author_id",
            nativeQuery = true)
    List<AuthorNameBookTitle> findAuthorsAndBooksSql();
}
