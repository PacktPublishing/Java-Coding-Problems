package modern.challenge.repository;

import java.util.List;
import modern.challenge.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import modern.challenge.projection.AuthorNameAge;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT a.name as name, a.age as age FROM Author a WHERE a.age >= ?1")
    List<AuthorNameAge> fetchByAge(int age);
}
