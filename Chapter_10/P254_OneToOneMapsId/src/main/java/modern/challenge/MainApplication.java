package modern.challenge;

import modern.challenge.entity.Author;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

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

            bookstoreService.newBook();
            bookstoreService.newAuthorOfBook();

            Author author = bookstoreService.findAuthorOfBook();
            System.out.println("Author details: " + author.getId()
                    + ", " + author.getName() + " " + author.getSurname() + ", " + author.getAge());
        };
    }
}