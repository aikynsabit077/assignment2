import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> adj;

    public Graph() {
        adj = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adj.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {

        adj.putIfAbsent(from, new ArrayList<>());
        adj.putIfAbsent(to, new ArrayList<>());

        adj.get(from).add(to);

        // for undirected graph:
        adj.get(to).add(from);
    }

    public void printGraph() {

        for (int v : adj.keySet()) {

            System.out.print(v + ": ");

            for (int n : adj.get(v)) {
                System.out.print(n + " ");
            }

            System.out.println();
        }
    }

    // BFS
    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        visited.add(start);
        q.add(start);

        while (!q.isEmpty()) {

            int current = q.poll();

            System.out.print(current + " ");

            for (int neighbor : adj.get(current)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    q.add(neighbor);

                }
            }
        }

        System.out.println();
    }

    // DFS
    public void dfs(int start) {

        Set<Integer> visited = new HashSet<>();

        dfsHelper(start, visited);

        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {

        visited.add(current);

        System.out.print(current + " ");

        for (int neighbor : adj.get(current)) {

            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}