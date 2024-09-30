/**
 * Represents a vertex in a graph with a unique name.
 */
public class Vertex {

    String name;
    /** Indicates the risk level present within the zone */
    int riskLevel;

    Vertex(String name, int riskLevel) {
        this.name = name;
        this.riskLevel = riskLevel;
    }
}
