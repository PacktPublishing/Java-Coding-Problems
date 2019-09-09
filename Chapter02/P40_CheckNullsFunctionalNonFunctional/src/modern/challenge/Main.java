package modern.challenge;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        List<Integer> numbers = Arrays.asList(1, 2, null, 4, null, 16, 7, null);
        
        int sum = Numbers.sumIntegers(numbers);
        boolean nulls = Numbers.integersContainsNulls(numbers);
        List<Integer> evens = Numbers.evenIntegers(numbers);
        
        System.out.println("Contain nulls? " + nulls);
        System.out.println("Sum: " + sum);
        System.out.println("Evens: " + evens);
    }
    
}
