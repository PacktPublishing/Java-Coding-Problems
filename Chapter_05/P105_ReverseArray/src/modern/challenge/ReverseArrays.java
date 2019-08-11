package modern.challenge;

public final class ReverseArrays {

    private ReverseArrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void reverse(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        for (int leftHead = 0, rightHead = arr.length - 1;
                leftHead < rightHead; leftHead++, rightHead--) {

            int elem = arr[leftHead];
            arr[leftHead] = arr[rightHead];
            arr[rightHead] = elem;
        }
    }
    
    public static <T> void reverse(T[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        for (int leftHead = 0, rightHead = arr.length - 1;
                leftHead < rightHead; leftHead++, rightHead--) {

            T elem = arr[leftHead];
            arr[leftHead] = arr[rightHead];
            arr[rightHead] = elem;
        }
    }    
}
