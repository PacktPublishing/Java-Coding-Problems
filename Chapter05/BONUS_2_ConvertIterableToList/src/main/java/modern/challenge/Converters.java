package modern.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Converters {

    private Converters() {
        throw new AssertionError("Cannot be instantiatied");
    }

    public static <T> List<T> iterableToList1(Iterable<T> iterable) {

        if (iterable == null) {
            return Collections.emptyList();
        }

        List<T> result = new ArrayList<>();
        iterable.forEach(result::add);

        return result;
    }

    public static <T> List<T> iterableToList2(Iterable<T> iterable) {

        if (iterable == null) {
            return Collections.emptyList();
        }

        List<T> result = StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        return result;
    }

    public static <T> List<T> iterableToList3(Iterable<T> iterable) {

        if (iterable == null) {
            return Collections.emptyList();
        }

        List<T> result = new ArrayList<>();
        iterable.iterator().forEachRemaining(result::add);

        return result;
    }

    public static <T> List<T> iterableToList4(Iterable<T> iterable) {

        if (iterable == null) {
            return Collections.emptyList();
        }

        List<T> result
                = StreamSupport.stream(Spliterators.
                        spliteratorUnknownSize(iterable.iterator(), Spliterator.ORDERED), false)
                        .collect(Collectors.toList());

        return result;
    }

    public static <T> List<T> iterableToList5(Iterable<T> iterable) {

        if (iterable == null) {
            return Collections.emptyList();
        }

        List<T> result = new ArrayList<>();
        for (T elem : iterable) {
            result.add(elem);
        }

        return result;
    }

    public static <T> List<T> iterableToList6(Iterable<T> iterable) {

        if (iterable == null) {
            return Collections.emptyList();
        }

        List<T> result = new ArrayList<>();
        Iterator<T> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        return result;
    }
    
}
