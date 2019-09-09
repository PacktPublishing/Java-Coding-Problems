package modern.challenge;

public class Main {

    public static void main(String[] args) {

        int s = 10;
        int m = 21;

        // if (s > m && m < 50)
        if (Boolean.logicalAnd(s > m, m < 50)) {
            System.out.println("Boolean.logicalAnd returned true");
        } else {
            System.out.println("Boolean.logicalAnd returned false");
        }

        // if (s > m || m < 50)
        if (Boolean.logicalOr(s > m, m < 50)) {
            System.out.println("Boolean.logicalOr returned true");
        } else {
            System.out.println("Boolean.logicalOr returned false");
        }

        // if (s > m ^ m < 50)
        if (Boolean.logicalXor(s > m, m < 50)) {
            System.out.println("Boolean.logicalXor returned true");
        } else {
            System.out.println("Boolean.logicalXor returned false");
        }

        if (Boolean.logicalAnd(
                Boolean.logicalOr(s > m, m < 50),
                Boolean.logicalOr(s <= m, m > 50))) {
            System.out.println("Combination returned true");
        } else {
            System.out.println("Combination returned false");
        }
    }

}
