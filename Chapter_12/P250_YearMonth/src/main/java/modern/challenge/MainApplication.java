package modern.challenge;

import modern.challenge.service.RoyaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final RoyaltyService royaltyService;

    public MainApplication(RoyaltyService royaltyService) {
        this.royaltyService = royaltyService;
    }        

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            royaltyService.newRoyalty();
            royaltyService.fetchRoyalty();
        };
    }

}
