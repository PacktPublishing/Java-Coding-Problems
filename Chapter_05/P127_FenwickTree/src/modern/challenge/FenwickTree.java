package modern.challenge;

import java.util.Arrays;

public class FenwickTree {

    private final int n;
    private long[] tree;

    public FenwickTree(int n) {
        this.n = n;
        this.tree = new long[n + 1];
    }

    public FenwickTree(long[] values) {

        if (values == null) {
            throw new IllegalArgumentException("Values array cannot be null");
        }

        values[0] = 0L;

        this.n = values.length;

        tree = values.clone();

        for (int i = 1; i < n; i++) {
            int parent = i + lsb(i);

            if (parent < n) {
                tree[parent] += tree[i];
            }
        }
    }

    public long sum(int left, int right) {

        if (right < left) {
            throw new IllegalArgumentException("Right should be greater or equal to left");
        }

        return prefixSum(right) - prefixSum(left - 1);
    }

    public long get(int i) {
        return sum(i, i);
    }

    public void add(int i, long v) {
        while (i < n) {
            tree[i] += v;
            i += lsb(i);
        }
    }

    public void set(int i, long v) {
        add(i, v - sum(i, i));
    }

    @Override
    public String toString() {
        return Arrays.toString(tree);
    }

    private long prefixSum(int i) {
        long sum = 0L;

        while (i != 0) {
            sum += tree[i];
            i &= ~lsb(i); // or, i -= lsb(i);
        }

        return sum;
    }

    private static int lsb(int i) {

        return i & -i;

        // or
        // return Integer.lowestOneBit(i);
    }
}
