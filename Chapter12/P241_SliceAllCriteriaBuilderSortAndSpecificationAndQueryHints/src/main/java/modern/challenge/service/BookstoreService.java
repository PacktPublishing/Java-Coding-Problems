package modern.challenge.service;

import modern.challenge.repository.AuthorRepository;
import javax.persistence.LockModeType;
import modern.challenge.entity.Author;
import static modern.challenge.service.AuthorSpecs.isAgeGt25;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {
     
    private final AuthorRepository authorRepository;
    
    public BookstoreService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
            
    public Slice<Author> fetchNextSlice(int page, int size) {
    
       // hint example
       // Map<String, Object> hints = new HashMap<>();
       // hints.put("org.hibernate.readOnly", true);
        
        return authorRepository.findAll(isAgeGt25(), 
                PageRequest.of(page, size, new Sort(Sort.Direction.ASC, "id")), 
                LockModeType.OPTIMISTIC_FORCE_INCREMENT);
    }
}
