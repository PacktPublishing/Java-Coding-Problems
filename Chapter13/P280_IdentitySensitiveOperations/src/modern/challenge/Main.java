package modern.challenge;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        
        Book book = new Book();

        Optional<Book> op1 = Optional.of(book);
        Optional<Book> op2 = Optional.of(book);

        // Avoid
        // op1 == op2 => false, expected true
        if (op1 == op2) {
            System.out.println("op1 is equal with op2, (via ==)");
        } else {
            System.out.println("op1 is not equal with op2, (via ==)");
        }
        
        // Prefer
        if (op1.equals(op2)) {
            System.out.println("op1 is equal with op2, (via equals())");
        } else {
            System.out.println("op1 is not equal with op2, (via equals())");
        }
    }

}
