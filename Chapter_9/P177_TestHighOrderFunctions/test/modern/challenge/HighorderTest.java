package modern.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import static modern.challenge.Main.reduceStrings;

import static modern.challenge.Main.replace;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HighorderTest {

    @Test
    public void testReplacer() throws Exception {

        List<String> names = Arrays.asList("Ann a 15", "Mir el 28", "D oru 33");
        List<String> resultWs = replace(names, (String s) -> s.replaceAll("\\s", ""));
        List<String> resultNr = replace(names, (String s) -> s.replaceAll("\\d", ""));

        assertEquals(Arrays.asList("Anna15", "Mirel28", "Doru33"), resultWs);
        assertEquals(Arrays.asList("Ann a ", "Mir el ", "D oru "), resultNr);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testReduceStrings() throws Exception {

        Function<String, String> f1 = (String s) -> s.toUpperCase();
        Function<String, String> f2 = (String s) -> s.concat(" DONE");

        Function<String, String> f = reduceStrings(f1, f2);

        assertEquals("TEST DONE", f.apply("test"));
    }
}
