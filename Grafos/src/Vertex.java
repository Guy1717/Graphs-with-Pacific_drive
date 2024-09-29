/**
 * Represents a vertex in a graph with a unique name.
 */
public class Vertex {

    String name;
    /** Indicates the risk level present within the zone */
    int weight;

    Vertex(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}
