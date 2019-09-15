package modern.challenge;

import io.mikael.urlbuilder.UrlBuilder;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {

        return args -> {

            URI uri1 = URI.create("http://localhost:8080/books?name="
                    + URLEncoder.encode("Games & Fun!", StandardCharsets.UTF_8)
                    + "&no=" + URLEncoder.encode("124#442#000", StandardCharsets.UTF_8)
                    + "&price=" + URLEncoder.encode("$23.99", StandardCharsets.UTF_8)
            );

            System.out.println("URI 1: " + uri1);

            URI uri2 = UriComponentsBuilder.newInstance()
                    .scheme("http")
                    .host("localhost")
                    .port(8080)
                    .path("books")
                    .queryParam("name", "Games & Fun!")
                    .queryParam("no", "124#442#000")
                    .queryParam("price", "$23.99")
                    .build()
                    .toUri();

            System.out.println("URI 2: " + uri2);

            URI uri3 = UrlBuilder.empty()
                    .withScheme("http")
                    .withHost("localhost")
                    .withPort(8080)
                    .withPath("books")
                    .addParameter("name", "Games & Fun!")
                    .addParameter("no", "124#442#000")
                    .addParameter("price", "$23.99")
                    .toUri();
            
            System.out.println("URI 3: " + uri3);
        };
    }
}
