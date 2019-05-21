package modern.challenge.repository;

import java.util.List;
import javax.persistence.QueryHint;
import modern.challenge.entity.Author;
import static org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Transactional(readOnly = true)
    @Query("select t from Author t left join fetch t.books")
    List<Author> fetchAuthorsLeftJoinBooksWithDuplicates();

    @Transactional(readOnly = true)
    @Query("select distinct t from Author t left join fetch t.books")
    List<Author> fetchAuthorsLeftJoinBooksWithoutHint();

    @Transactional(readOnly = true)
    @Query("select distinct t from Author t left join fetch t.books")
    @QueryHints(value = @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false"))
    List<Author> fetchAuthorsLeftJoinBooksWithHint();
}
