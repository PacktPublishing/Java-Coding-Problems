package modern.challenge.repository;

import modern.challenge.entity.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly=true)
public interface AuthorRepository extends JpaRepository<Author, Long> {   
    
    List<Author> findByAgeGreaterThanEqual(int age);
}

