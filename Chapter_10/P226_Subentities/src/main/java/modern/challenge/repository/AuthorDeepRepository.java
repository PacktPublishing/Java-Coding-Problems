package modern.challenge.repository;

import modern.challenge.entity.AuthorDeep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDeepRepository extends JpaRepository<AuthorDeep, Long> {
}
