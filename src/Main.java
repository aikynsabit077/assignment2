import java.util.*;

class Edge {
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    private int vertices;
    private LinkedList<Edge>[] adjList;

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjList[source].add(new Edge(destination, weight));

        adjList[destination].add(new Edge(source, weight));
    }

    public void dijkstra(int start) {
        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[start] = 0;

        for (int i = 0; i < vertices - 1; i++) {

            int u = minDistance(distance, visited);

            visited[u] = true;

            for (Edge edge : adjList[u]) {
                int v = edge.destination;
                int weight = edge.weight;

                if (!visited[v] &&
                        distance[u] != Integer.MAX_VALUE &&
                        distance[u] + weight < distance[v]) {

                    distance[v] = distance[u] + weight;
                }
            }
        }

        System.out.println("Shortest distances from vertex " + start + ":");

        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + " = " + distance[i]);
        }
    }

    private int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(5);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);

        graph.dijkstra(0);
    }
}