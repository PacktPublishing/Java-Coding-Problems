package modern.challenge;

import modern.challenge.naturalid.NaturalRepositoryImpl;
import modern.challenge.service.BookstoreService;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = NaturalRepositoryImpl.class)
public class MainApplication {

    private static final Logger logger = Logger.getLogger(MainApplication.class.getName());

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.insertTwoBooks();
            bookstoreService.fetchOneBookByNaturalId();
        };
    }
}
