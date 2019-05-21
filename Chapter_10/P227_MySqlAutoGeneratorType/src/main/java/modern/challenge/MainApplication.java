package modern.challenge;

import java.util.logging.Logger;
import modern.challenge.repository.AuthorBadRepository;
import modern.challenge.repository.AuthorGoodRepository;
import modern.challenge.entity.AuthorGood;
import modern.challenge.entity.AuthorBad;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private static final Logger logger = Logger.getLogger(MainApplication.class.getName());

    private final AuthorGoodRepository authorGoodRepository;
    private final AuthorBadRepository authorBadRepository;

    public MainApplication(AuthorGoodRepository authorGoodRepository,
            AuthorBadRepository authorBadRepository) {
        this.authorGoodRepository = authorGoodRepository;
        this.authorBadRepository = authorBadRepository;
    }

    public static void main(String[] args) {     
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {

        return args -> {

            AuthorGood authorGood = new AuthorGood();
            authorGood.setName("Good");
            authorGood.setSurname("Author");
            authorGood.setAge(20);

            logger.info("Save a good author ...");
            authorGoodRepository.save(authorGood);

            AuthorBad authorBad = new AuthorBad();
            authorBad.setName("Bad");
            authorBad.setSurname("Author");
            authorBad.setAge(20);

            logger.info("Save a bad author ...");
            authorBadRepository.save(authorBad);
        };
    }
}
