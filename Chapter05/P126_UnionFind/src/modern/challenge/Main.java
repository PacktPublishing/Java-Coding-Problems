package modern.challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println("Disjoint set without path compression:");
        System.out.println("--------------------------------------");

        DisjointSet set = new DisjointSet(11);

        set.union(0, 1);
        set.union(4, 9);
        set.union(6, 5);
        set.union(0, 7);
        set.union(4, 3);
        set.union(4, 2);
        set.union(6, 10);
        set.union(4, 5);

        System.out.println("Parent: 4");
        set.printFromRoot(4);

        // is 4 and 0 friends => false
        System.out.println("\nIs 4 and 0 friends: " + (set.find(0) == set.find(4)));

        // is 4 and 5 friends => true
        System.out.println("Is 4 and 5 friends: " + (set.find(4) == set.find(5)));

        System.out.println("\nDisjoint set with path compression:");
        System.out.println("------------------------------------");

        DisjointSetCompression setc = new DisjointSetCompression(12);

        setc.union(0, 1);
        setc.union(4, 9);
        setc.union(6, 5);
        setc.union(0, 7);
        setc.union(4, 3);
        setc.union(4, 2);
        setc.union(6, 10);
        setc.union(4, 5);

        System.out.println("Parent: 4");
        set.printFromRoot(4);

        System.out.println("\nCalling find(5) now will cause path compression (4 <- 6 <- 5) = (4 <- 5)");
        System.out.println("Calling find(10) now will cause path compression (4 <- 6 <- 10) = (4 <- 10)\n");

        // calling find(5) and find(10) will cause path compression for 5 and 10
        setc.find(5);
        setc.find(10);

        System.out.println("Parent: 4");
        setc.printFromRoot(4); // 4 <- 5; 4 <- 10;         
    }
}
