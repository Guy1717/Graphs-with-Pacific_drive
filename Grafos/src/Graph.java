import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a graph with vertices and edges, allowing operations to add
 * vertices and edges,
 * check for existence, and retrieve graph properties such as adjacency lists
 * and edge weights.
 */
public class Graph {

    List<Vertex> vertices;
    List<Edge> edges;
    boolean bidirectional;

    public Graph(boolean isBidirectional) {

        bidirectional = isBidirectional;

        vertices = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();

    }

    /**
     * Adds a vertex to the graph if it does not already exist.
     *
     * @param name      the name of the vertex
     * @param riskLevel the risk level of the vertex
     */
    public void addVertex(String name, int riskLevel) {
        // If already in the graph
        if (contains(name))
            return;

        Vertex v = new Vertex(name, riskLevel);
        vertices.add(v);

    }

    /**
     * Adds a directed edge between two given vertices.
     *
     * @param origin
     * @param destiny
     * @param distance distance of the edge
     */
    public void addEdge(Vertex origin, Vertex destiny, int distance) {

        int riskLevel = origin.riskLevel + destiny.riskLevel;

        Edge edge = new Edge(origin, destiny, distance, riskLevel);

        edges.add(edge);
    }

    /**
     * Adds an edge between two vertices identified by their names.
     * <p>
     * If the graph is bidirectional, the edge is added in both directions.
     *
     * @param originName  the name of the starting vertex
     * @param destinyName the name of the ending vertex
     * @param weight      the weight of the edge
     */
    public void addEdge(String originName, String destinyName, int distance) {

        if (contains(originName, destinyName)) {

            Vertex origin = getVertexByName(originName);
            Vertex destiny = getVertexByName(destinyName);

            addEdge(origin, destiny, distance);

            if (bidirectional)
                if (!origin.name.equals(destiny.name))
                    addEdge(destiny, origin, distance);
        }
    }

    /**
     * Retrieves a vertex from the graph by its name.
     *
     * @param name the name of the vertex to retrieve
     * @return the vertex with the given name, or null if not found
     */
    public Vertex getVertexByName(String name) {

        for (Vertex v : vertices)
            if (v.name.equals(name))
                return v;

        return null;
    }

    /**
     * Checks if a vertex with the specified name exists in the graph.
     *
     * @param vertexName the name of the vertex to check
     * @return true if the vertex exists, false otherwise
     */
    public boolean contains(String... verticesName) {

        /** A map that associates vertex names with a boolean (presence status) */
        Map<String, Boolean> checklist = new HashMap<String, Boolean>();

        // Inicialize the map
        for (String name : verticesName)
            checklist.put(name, false);

        // Check the presence in the graph
        for (Vertex v : vertices) {

            String name = v.name;

            if (checklist.containsKey(name))
                checklist.put(name, true);

        }

        // If any vertex is not present in the graph
        if (checklist.containsValue(false))
            return false;

        return true;
    }

    /**
     * Returns the total number of edges in the graph.
     *
     * @return the total number of edges
     */
    public int getTotalEdges() {
        return edges.size();
    }

    /**
     * Returns the total number of vertices in the graph.
     *
     * @return the total number of vertices
     */
    public int getTotalVertices() {
        return vertices.size();
    }

    /**
     * Prints the names of all vertices in the graph.
     */
    public void printVertices() {

        for (Vertex v : vertices) {
            System.out.printf("[%s]", v.name);
        }

        System.out.println();

    }

    /**
     * Prints all edges in the graph.
     */
    public void printEdges() {

        for (Edge e : edges)
            printEdge(e);

    }

    /**
     * Prints a specific edge's details.
     *
     * @param e the edge to print
     */
    public void printEdge(Edge e) {

        System.out.printf("%s -> %s (%d)\n", e.origin.name, e.destiny.name, e.distance);

    }

    /**
     * Generates and returns the adjacency list representation of the graph.
     *
     * @return a map representing the adjacency list of the graph
     */
    public Map<Vertex, List<Vertex>> getAdjacencyList() {

        Map<Vertex, List<Vertex>> adjacencyList = new HashMap<Vertex, List<Vertex>>();

        for (Vertex v : vertices) {
            List<Vertex> destinies = new ArrayList<Vertex>();

            for (Edge e : edges) {

                if (e.origin.name.equals(v.name))
                    destinies.add(e.destiny);

            }

            adjacencyList.put(v, destinies);
        }

        return adjacencyList;
    }

    /**
     * Prints the adjacency list of the graph.
     *
     * @param adjList the adjacency list to print
     */
    public void printAdjacencyList(Map<Vertex, List<Vertex>> adjList) {
        for (Vertex v : adjList.keySet()) {
            System.out.printf("%s: ", v.name);

            for (Vertex destiny : adjList.get(v)) {

                // possibility to print:
                // int distance = getEdgeDistance(v, destiny);
                // int riskLevel = getEdgeRisk(v, destiny);

                System.out.printf("[%s] ", destiny.name);

            }

            System.out.println();
        }
    }

    /**
     * Retrieves the distance of the edge between two vertices.
     *
     * @param origin
     * @param destiny
     * @return the distance of the edge, or Integer.MAX_VALUE if no edge exists
     */
    public int getEdgeDistance(Vertex origin, Vertex destiny) {
        for (Edge e : edges) {

            if (e.origin.equals(origin) && e.destiny.equals(destiny))
                return e.distance;

        }
        return Integer.MAX_VALUE; // No edge found
    }

    /**
     * Retrieves the risk level of the edge between two vertices.
     *
     * @param origin
     * @param destiny
     * @return the risk of the edge, or Integer.MAX_VALUE if no edge exists
     */
    public int getEdgeRisk(Vertex origin, Vertex destiny) {

        for (Edge e : edges) {

            if (e.origin.equals(origin) && e.destiny.equals(destiny))
                return e.riskLevel;

        }
        return Integer.MAX_VALUE; // No edge found
    }

}
