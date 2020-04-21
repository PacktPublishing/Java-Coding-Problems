package modern.challenge.shallow.copy.matrix;

import java.util.Arrays;

public final class Matrices {

    private Matrices() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int[][] cloneArrayOfInt1(int[][] source) {

        if (source == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        int length = source.length;
        int[][] target = new int[length][source[0].length];

        for (int i = 0; i < length; i++) {
            target[i] = source[i].clone();
        }

        return target;
    }

    public static int[][] cloneArrayOfInt2(int[][] source) {

        if (source == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        int length = source.length;
        int[][] target = new int[length][source[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(source[i], 0, target[i], 0, source[i].length);
        }
        return target;
    }

    public static int[][] cloneArrayOfInt3(int[][] source) {

        if (source == null) {
            throw new IllegalArgumentException("The given array cannot be null");
        }

        int length = source.length;
        int[][] target = new int[length][];
        for (int i = 0; i < length; i++) {
            target[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return target;
    }

    public static int[][] cloneArrayOfInt4(int[][] source) {
        return Arrays.stream(source)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

}
