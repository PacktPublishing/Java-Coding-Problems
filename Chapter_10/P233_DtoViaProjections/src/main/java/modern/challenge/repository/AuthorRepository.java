package modern.challenge.repository;

import java.util.List;
import modern.challenge.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import modern.challenge.projection.AuthorNameAge;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {      
    
    @Transactional(readOnly = true)
    List<AuthorNameAge> findFirst2ByBirthplace(String birthplace);
}

