package modern.challenge;

import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {

        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        int z = x + y;
        System.out.println(x + " + " + y + " via '+' operator is: " + z);

        int zSum = Integer.sum(x, y);
        System.out.println(x + " + " + y + " via Integer.sum() is: " + zSum);

        // throw ArithmeticException
        int zExact = Math.addExact(x, y);
        System.out.println(x + " + " + y + " via Math.addExact() is: " + zExact);

        // throw ArithmeticException
        BinaryOperator<Integer> operator = Math::addExact;
        int zExactBo = operator.apply(x, y);
        System.out.println(x + " + " + y + " via BinaryOperator is: " + zExactBo);
    }
}
