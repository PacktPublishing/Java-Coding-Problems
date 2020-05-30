package modern.challenge;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Convert list of String to list of ints:");
        List<String> strList = Arrays.asList("11", "22", "33");
        List<Integer> intList = Convertors.list(strList, Integer::parseInt);
        System.out.println("strList: " + strList);
        System.out.println("intList: " + intList);

        System.out.println("\n\nConvert array of String to array of doubles:");
        String[] strArr = {"11", "22", "34"};
        Double[] doubleArr = Convertors.array(strArr, Double::parseDouble, Double[]::new);
        System.out.println("strArr: " + Arrays.toString(strArr));
        System.out.println("doubleArr: " + Arrays.toString(doubleArr));
    }
}
