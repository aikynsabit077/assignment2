Bonus Task – Dijkstra’s Algorithm

For the bonus task, Dijkstra’s Algorithm was implemented to find the shortest path from a selected starting vertex to all other vertices in the graph.

Purpose of the Algorithm

Dijkstra’s Algorithm is used in weighted graphs to calculate the minimum distance between vertices. It is commonly used in navigation systems, maps, and network routing because it finds the shortest possible path.

Changes Made to the Project

To implement this algorithm, the graph structure had to be modified to support weighted edges.

Updated Edge Class

The `Edge` class was changed by adding a `weight` field.  
Now each edge stores:
- destination vertex
- edge weight

Example:

```java
class Edge {
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
