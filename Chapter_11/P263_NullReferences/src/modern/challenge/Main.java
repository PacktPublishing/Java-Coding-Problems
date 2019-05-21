package modern.challenge;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws ReflectiveOperationException {

        // Method method = Book.class.getDeclaredMethod("printNonStatic");
        Method method = Book.class.getDeclaredMethod("printStatic");

        Optional<Book> bookInstance = fetchBookInstance(method);

        // Avoid
        if (bookInstance.isPresent()) {
            method.invoke(bookInstance.get());
        } else {
            method.invoke(null);
        }

        // Prefer
        method.invoke(bookInstance.orElse(null));
    }

    private static Optional<Book> fetchBookInstance(Method method) {

        if (Modifier.isStatic(method.getModifiers())) {
            return Optional.empty();
        }

        return Optional.of(new Book());
    }
}
