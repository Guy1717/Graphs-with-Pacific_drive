/**
 * Represents an edge in a graph, connecting two vertices with an associated
 * weight and risk level.
 */
public class Edge {

    Vertex origin;
    Vertex destiny;
    int distance;
    int riskLevel;

    Edge(Vertex origin, Vertex destiny, int distance, int riskLevel) {
        this.origin = origin;
        this.destiny = destiny;
        this.distance = distance;
        this.riskLevel = riskLevel;
    }

    /**
     * Checks if the edge contains the specified vertex.
     *
     * @param vertex the vertex to check
     * @return true if the vertex is either the origin or destiny of the edge, false
     *         otherwise
     */
    public boolean contains(Vertex vertex) {

        String origin = this.origin.name;
        String destiny = this.destiny.name;

        return vertex.name.equals(origin) || vertex.name.equals(destiny);
    }

}
