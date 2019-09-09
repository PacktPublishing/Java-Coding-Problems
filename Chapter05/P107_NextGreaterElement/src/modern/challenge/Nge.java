package modern.challenge;

import java.util.Stack;

public final class Nge {

    private Nge() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static void println(int[] arr) {

        int nge;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            nge = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    nge = arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + " : " + nge);
        }
    }

    public static int[] fetch(int[] arr) {

        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int nge[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {

            if (!stack.empty()) {
                while (!stack.empty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }

            nge[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return nge;
    }
}
