package modern.challenge;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(4);

        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(3, 2);
        graph.addEdge(3, 3);
        
        graph.BFS(0);
    }

}
