package modern.challenge;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println(add1(4));
        System.out.println(add2(5));
    }

    public static <T extends Number> T add1(T t) {
        var temp = t;

        return temp;
    }

    public static <T extends Number> T add2(T t) {
        var numberList = new ArrayList<T>();

        //var numberList = new ArrayList<>(); // DON'T DO THIS, DON'T FORGET THE, T
        
        numberList.add(t);
        numberList.add((T) Integer.valueOf(3));
        numberList.add((T) Double.valueOf(3.9));

        // numberList.add("5"); // error: incompatible types: String cannot be converted to T    
        
        return numberList.get(0);
    }

}
