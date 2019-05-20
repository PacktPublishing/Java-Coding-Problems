package modern.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

    }

    @SuppressWarnings("unchecked")
    public static Function<String, String> reduceStrings(Function<String, String>... functions) {
        Function<String, String> function = Stream.of(functions)
                .reduce(Function.identity(), Function::andThen);

        return function;
    }

    public static List<String> replace(List<String> list, Replacer<String> r) {

        if (list == null || r == null) {
            throw new IllegalArgumentException("List/replacer cannot be null");
        }

        List<String> result = new ArrayList<>();
        for (String s : list) {
            result.add(r.replace(s));
        }

        return result;
    }

}
