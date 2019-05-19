package modern.challenge;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[10];

        // fill up an array
        Arrays.fill(arr, 1);
        System.out.println("Fill up with 1: " + Arrays.toString(arr));

        // set all via a generator function       
        Arrays.setAll(arr, t -> {
            if (t == 0) {
                return arr[t];
            } else {
                return arr[t - 1] + 1;
            }
        });
        System.out.println("Compute each value as the preceding one + 1: " + Arrays.toString(arr));

        // set all in parallel via a generator function
        Arrays.parallelSetAll(arr, t -> {
            if (arr[t] % 2 == 0) {
                return arr[t] * arr[t];
            } else {
                return arr[t] - 1;
            }
        });
        System.out.println("Multiply even values with "
                + "themself and decrease by 1 the odd values: " + Arrays.toString(arr));

        Arrays.parallelPrefix(arr, (t, q) -> t + q);
        System.out.println("Compute each element of the "
                + "array as the sum of the preceding elements: " + Arrays.toString(arr));        
    }

}
