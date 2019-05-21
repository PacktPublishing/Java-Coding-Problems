package modern.challenge.repository;

import modern.challenge.entity.AuthorBad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorBadRepository extends JpaRepository<AuthorBad, Long> {        
}

