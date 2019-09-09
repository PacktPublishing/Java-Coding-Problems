package modern.challenge;

public class Main {

    public static void main(String[] args) {

        int[] integers = {1, 2, 3, 4, 12, 2, 1, 4};

        System.out.println("Quick solution:");
        Nge.println(integers);

        System.out.println("\nStack based solution:");
        int[] nge = Nge.fetch(integers);
        for (int i = 0; i < integers.length; i++) {
            System.out.println(integers[i] + " : " + nge[i]);
        }
    }

}
