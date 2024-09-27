import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

    // Attributes
    Set<Vertex> vertices;
    Set<Edge> edges;
    boolean bidirectional;

    // Constructors
    public Graph(boolean isBidirectional) {
        bidirectional = isBidirectional;

        vertices = new HashSet<Vertex>();
        edges = new HashSet<Edge>();
    }

    // Functions
    public void addVertex(String name) {
        vertices.add(new Vertex(name));
    }

    public void addEdge(Vertex origin, Vertex destiny, int weight) {
        edges.add(new Edge(origin, destiny, weight));
    }

    public void addEdge(String originName, String destinyName, int weight) {

        if (contains(originName, destinyName)) {
            Vertex origin = getVertexByName(originName);
            Vertex destiny = getVertexByName(destinyName);

            addEdge(origin, destiny, weight);

            if (bidirectional)
                if (!origin.name.equals(destiny.name))
                    addEdge(destiny, origin, weight);
        }

    }

    public Vertex getVertexByName(String name) {

        for (Vertex v : vertices)
            if (v.name.equals(name))
                return v;

        return null;
    }

    public boolean contains(String vertexName) {

        for (Vertex v : vertices) {
            if (v.name.equals(vertexName))
                return true;
        }

        return false;
    }

    public boolean contains(String initialVertexName, String finalVertexName) {

        boolean exists0 = false;
        boolean exists1 = false;

        for (Vertex v : vertices) {

            if (v.name.equals(initialVertexName))
                exists0 = true;

            if (v.name.equals(finalVertexName))
                exists1 = true;

        }

        return exists0 && exists1;
    }

    public int getTotalEdges() {
        return edges.size();
    }

    public int getTotalVertices() {
        return vertices.size();
    }

    public void printVertices() {
        for (Vertex v : vertices) {
            System.out.printf("[%s]", v.name);
        }
        System.out.println();
    }

    public void printEdges() {
        for (Edge e : edges)
            printEdge(e);
    }

    public void printEdge(Edge e) {
        System.out.printf("%s -> %s (%d)\n", e.origin.name, e.destiny.name, e.weight);
    }

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

    public void printAdjacencyList(Map<Vertex, List<Vertex>> adjList) {
        for (Vertex v : adjList.keySet()) {
            System.out.printf("%s: ", v.name);

            for (Vertex destiny : adjList.get(v)) {
                System.out.printf("[%s] ", destiny.name);
            }

            System.out.println();
        }
    }

    public int getEdgeWeight(Vertex origin, Vertex destiny) {
        for (Edge e : edges) {
            if (e.origin.equals(origin) && e.destiny.equals(destiny)) {
                return e.weight;
            }
        }
        return Integer.MAX_VALUE; // No edge found
    }

}
