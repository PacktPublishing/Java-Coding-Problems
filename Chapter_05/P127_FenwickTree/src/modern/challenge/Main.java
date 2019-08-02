package modern.challenge;

public class Main {

    public static void main(String[] args) {

        FenwickTree tree = new FenwickTree(new long[]{
            0, 3, 1, 5, 8, 12, 9, 7, 13, 0, 3, 1, 4, 9, 0, 11, 5
        });

        // [0, 3, 4, 5, 17, 12, 21, 7, 58, 0, 3, 1, 8, 9, 9, 11, 91]
        System.out.println(tree);

        System.out.println("----------------------------------");
        // Sum [2,9]
        long sum29 = tree.sum(2, 9);
        System.out.println("Sum [2, 9]: " + sum29 + "\n"); // 55

        tree.set(4, 3);
        // [0, 3, 4, 5, 12, 12, 21, 7, 53, 0, 3, 1, 8, 9, 9, 11, 86]
        System.out.println(tree);
        
        System.out.println("----------------------------------");
        long setsum29 = tree.sum(2, 9);
        System.out.println("Sum [2, 9]: " + setsum29 + "\n"); // 50

        tree.add(4, 5);
        // [0, 3, 4, 5, 17, 12, 21, 7, 58, 0, 3, 1, 8, 9, 9, 11, 91]
        System.out.println(tree);
        
        System.out.println("----------------------------------");
        long addsum29 = tree.sum(2, 9);
        System.out.println("Sum [2, 9]: " + addsum29); // 55                 
    }
}
