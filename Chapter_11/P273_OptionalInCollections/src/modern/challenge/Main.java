package modern.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    private static final String NOT_FOUND = "NOT FOUND";
    
    public static void main(String[] args) {
        System.out.println("Avoid:");

        // Avoid
        Map<String, Optional<String>> isbns1 = new HashMap<>();
        isbns1.put("Book1", Optional.ofNullable(null));
        isbns1.put("Book2", Optional.ofNullable("123-456-789"));

        Optional<String> isbn = isbns1.get("Book1");
        if (isbn == null) {
            System.out.println("This key cannot be found");
        } else {
            String unwrappedIsbn = isbn.orElse(NOT_FOUND);
            System.out.println("Key found, Value: " + unwrappedIsbn);
        }

        System.out.println("\nPrefer:");

        // Prefer (Java 8)
        Map<String, String> isbns2 = new HashMap<>();
        isbns2.put("Book1", null);
        isbns2.put("Book2", "123-456-789");

        String isbn1 = get(isbns2, "Book1");  // null
        String isbn2 = get(isbns2, "Book2");  // 123-456-789
        String isbn3 = get(isbns2, "Book3");  // NOT FOUND

        System.out.println("Value for key Book1: " + isbn1);
        System.out.println("Value for key Book2: " + isbn2);
        System.out.println("Value for key Book3: " + isbn3);
    }

    private static String get(Map<String, String> map, String key) {
        return map.getOrDefault(key, NOT_FOUND);
    }

}
