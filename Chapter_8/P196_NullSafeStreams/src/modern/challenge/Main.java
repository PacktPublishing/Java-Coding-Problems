package modern.challenge;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Null element: "
                + AsStreams.elementAsStream(null).count());
        System.out.println("Non null element: "
                + AsStreams.elementAsStream("Hello world").count());

        List<Integer> ints = Arrays.asList(5, null, 6, null, 1, 2);
        System.out.println("Null collection: "
                + AsStreams.collectionAsStreamWithNulls(null).count());
        System.out.println("Non-null collection with nulls: "
                + AsStreams.collectionAsStreamWithNulls(ints).count());
        System.out.println("Non-null collection without nulls: "
                + AsStreams.collectionAsStreamWithoutNulls(ints).count());
        System.out.println("Null collection or non-null collection with nulls: "
                + AsStreams.collectionAsStream(ints).count());
        System.out.println("Null collection or non-null collection with nulls: "
                + AsStreams.collectionAsStream(null).count());
    }

}
