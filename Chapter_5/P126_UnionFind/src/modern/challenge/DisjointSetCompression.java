package modern.challenge;

public class DisjointSetCompression {

    private final int[] rank;
    private final int[] parent;
    private final int n;

    public DisjointSetCompression(int n) {
        this.n = n;
        rank = new int[n];
        parent = new int[n];

        initializeDisjointSet();
    }

    public int find(int x) {

        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {

        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            return;
        }

        if (rank[xRoot] < rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    public void printFromRoot(int root) {

        for (int i = 0; i < n; i++) {
            if (i != root && parent[i] == root) {
                System.out.println("Child: " + i + " Parent: " + root);
                printFromRoot(i);
            }
        }
    }

    private void initializeDisjointSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

}
