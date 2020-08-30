package modern.challenge;

import java.util.Arrays;

public class MainApplication {

    public static void main(String[] args) {

        // let's consider the next Iterable
        Iterable<String> iterable = Arrays.asList("ana", "george", "mark");
        
        System.out.println("iterableToList1(): " + Converters.iterableToList1(iterable));
        System.out.println("iterableToList2(): " + Converters.iterableToList2(iterable));
        System.out.println("iterableToList3(): " + Converters.iterableToList3(iterable));
        System.out.println("iterableToList4(): " + Converters.iterableToList4(iterable));
        System.out.println("iterableToList5(): " + Converters.iterableToList5(iterable));
        System.out.println("iterableToList6(): " + Converters.iterableToList6(iterable));
    }
}
