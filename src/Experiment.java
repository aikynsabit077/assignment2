import java.util.Random;

public class Experiment {

    public Graph createGraph(int size) {

        Graph g = new Graph();

        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        Random rand = new Random();

        for (int i = 0; i < size * 2; i++) {

            int from = rand.nextInt(size);
            int to = rand.nextInt(size);

            if (from != to) {
                g.addEdge(from, to);
            }
        }

        return g;
    }

    public long runBFS(Graph g) {

        long start = System.nanoTime();

        g.bfs(0);

        long end = System.nanoTime();

        return end - start;
    }

    public long runDFS(Graph g) {

        long start = System.nanoTime();

        g.dfs(0);

        long end = System.nanoTime();

        return end - start;
    }

    public void runTraversals(Graph g) {

        System.out.println("BFS:");
        long bfsTime = runBFS(g);

        System.out.println("DFS:");
        long dfsTime = runDFS(g);

        System.out.println("BFS time: " + bfsTime);
        System.out.println("DFS time: " + dfsTime);
    }

    public void runMultipleTests() {

        int[] sizes = {10, 30, 100};

        for (int size : sizes) {

            System.out.println("\nGRAPH SIZE = " + size);

            Graph g = createGraph(size);

            if (size == 10) {

                System.out.println("\nGraph:");

                g.printGraph();

                System.out.println();
            }

            runTraversals(g);

            System.out.println("-------------------");
        }
    }

    public void printResults() {

        System.out.println("Experiments completed.");
    }
}