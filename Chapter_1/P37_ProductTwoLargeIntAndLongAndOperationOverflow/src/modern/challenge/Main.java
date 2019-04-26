package modern.challenge;

import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {              

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        int z = x * y;
        System.out.println(x + " * " + y + " via '*' operator is: " + z);
        
        long zFull = Math.multiplyFull(x, y);       
        System.out.println(x + " * " + y + " via Math.multiplyFull() is: " + zFull);
                        
        // throw ArithmeticException
        int zExact = Math.multiplyExact(x, y);
        System.out.println(x + " * " + y + " via Math.multiplyExact() is: " + zExact);                
        
        // throw ArithmeticException
        BinaryOperator<Integer> operator = Math::multiplyExact;
        int zExactBo = operator.apply(x, y);
        System.out.println(x + " * " + y + " via BinaryOperator is: " + zExactBo);                
    }

}
