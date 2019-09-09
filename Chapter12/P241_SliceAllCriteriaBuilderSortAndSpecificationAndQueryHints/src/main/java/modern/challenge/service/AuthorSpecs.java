package modern.challenge.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modern.challenge.entity.Author;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecs {

    private static final int AGE = 25;

    public static Specification<Author> isAgeGt25() {
        return (Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder builder)
                -> builder.greaterThan(root.get("age"), AGE);
    }
}
