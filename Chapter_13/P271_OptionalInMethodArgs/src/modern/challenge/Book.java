package modern.challenge;

import java.util.Objects;
import java.util.Optional;

public class Book {

    // Avoid
    public void renderBook(Format format, Optional<Renderer> renderer, Optional<String> size) {

        Objects.requireNonNull(format, "Format cannot be null");

        Renderer bookRenderer = renderer.orElseThrow(
                () -> new IllegalArgumentException("Renderer cannot be empty")
        );

        String bookSize = size.orElseGet(() -> "125 x 200");

        System.out.println("Rendering ...");
    }

    // Prefer
    public void renderBook(Format format, Renderer renderer, String size) {

        Objects.requireNonNull(format, "Format cannot be null");
        Objects.requireNonNull(renderer, "Renderer cannot be null");
        String bookSize = Objects.requireNonNullElseGet(size, () -> "125 x 200");

        System.out.println("Rendering ...");
    }

}
