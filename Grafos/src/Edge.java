/**
 * Represents an edge in a graph, connecting two vertices with an associated
 * weight.
 */
public class Edge {

    Vertex origin;
    Vertex destiny;
    /** Indicates the distance between the origin and the destiny */
    int weight;

    Edge(Vertex origin, Vertex destiny, int weight) {
        this.origin = origin;
        this.destiny = destiny;
        this.weight = weight;
    }

    /**
     * Checks if the edge contains the specified vertex.
     *
     * @param vertex the vertex to check
     * @return true if the vertex is either the origin or destiny of the edge, false
     *         otherwise
     */
    public boolean contains(Vertex vertex) {

        if (vertex.name.equals(origin.name) || vertex.name.equals(destiny.name))
            return true;

        return false;
    }

}
