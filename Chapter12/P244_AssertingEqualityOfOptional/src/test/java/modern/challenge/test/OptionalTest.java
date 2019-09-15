package modern.challenge.test;

import java.util.Optional;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class OptionalTest {

    private final Optional<String> actualIsbn = Optional.of("123-456-789");
    private final Optional<String> expectedIsbn = Optional.of("123-456-789");

    // Avoid
    @Test
    public void givenIsbnsWhenTestEqualityThenTrue_Avoid() throws Exception {

        assertEquals(expectedIsbn.get(), actualIsbn.get());
    }

    // Prefer
    @Test
    public void givenIsbnsWhenTestEqualityThenTrue_Prefer() throws Exception {

        assertEquals(expectedIsbn, actualIsbn);
    }
}
