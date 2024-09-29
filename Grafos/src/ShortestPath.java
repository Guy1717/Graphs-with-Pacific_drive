import java.util.List;

/**
 * Represents the result of a shortest path calculation, including the path and
 * its total weight.
 */
public class ShortestPath {
    private List<Vertex> path;
    private int totalWeight;

    public ShortestPath(List<Vertex> path, int totalWeight) {
        this.path = path;
        this.totalWeight = totalWeight;
    }

    /**
     * Returns the list of vertices that form the shortest path.
     *
     * @return the path as a list of vertices
     */
    public List<Vertex> getPath() {
        return path;
    }

    /**
     * Returns the total weight of the shortest path.
     *
     * @return the total weight of the path
     */
    public int getTotalWeight() {
        return totalWeight;
    }
}
