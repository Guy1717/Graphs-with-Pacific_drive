import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {

    public Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public ShortestPath shortestPath(String initialVertexName, String finalVertexName) {
        Vertex initialVertex = graph.getVertexByName(initialVertexName);
        Vertex finalVertex = graph.getVertexByName(finalVertexName);

        // In case of inexistent vertex
        if (initialVertex == null || finalVertex == null)
            return null;

        // Store the shortest distance from start to each vertex
        Map<Vertex, Integer> distances = new HashMap<>();
        Map<Vertex, Vertex> previousVertices = new HashMap<>();
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        // Initialize distances
        for (Vertex v : graph.vertices) {
            distances.put(v, Integer.MAX_VALUE); // Set initial distances to "infinity"
            previousVertices.put(v, null); // No previous vertex at the start
        }
        distances.put(initialVertex, 0);
        pq.add(initialVertex);

        // Keep track of visited vertices
        Set<Vertex> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            // Skip this vertex if it has already been visited
            if (visited.contains(currentVertex)) {
                continue;
            }
            visited.add(currentVertex);

            // Early exit if we reached the destination vertex
            if (currentVertex.equals(finalVertex)) {
                break;
            }

            // Visit each neighbor of the current vertex
            List<Vertex> neighbors = graph.getAdjacencyList().get(currentVertex);
            if (neighbors != null) {
                for (Vertex neighbor : neighbors) {
                    int edgeWeight = graph.getEdgeWeight(currentVertex, neighbor);
                    int newDistance = distances.get(currentVertex) + edgeWeight;

                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        previousVertices.put(neighbor, currentVertex);
                        pq.add(neighbor); // Reinserts the neighbor into the priority queue
                    }
                }
            }
        }

        // Reconstruct the shortest path
        List<Vertex> path = new ArrayList<>();
        int totalWeight = distances.get(finalVertex); // Get the total weight

        for (Vertex at = finalVertex; at != null; at = previousVertices.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        if (path.isEmpty() || !path.get(0).equals(initialVertex)) {
            return new ShortestPath(Collections.emptyList(), Integer.MAX_VALUE); // Return empty path and infinite
                                                                                       // weight
        }

        return new ShortestPath(path, totalWeight);
    }

    public void print(String initialVertexName, String finalVertexName) {
        ShortestPath result = shortestPath(initialVertexName, finalVertexName);

        if (result.getPath().isEmpty()) { // Inexistent path
            System.out.println("Inexistent path...");
            return;
        }

        System.out.printf("# Shortest path between [%s] and [%s]\n", initialVertexName, finalVertexName);
        for (Vertex v : result.getPath()) {
            System.out.printf("[%s] ", v.name);
        }
        System.out.println();

        // Print the total weight
        System.out.printf("Total Weight: %d\n", result.getTotalWeight());
    }

}
