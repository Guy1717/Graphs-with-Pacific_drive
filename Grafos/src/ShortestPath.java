import java.util.List;

public class ShortestPath {
    private List<Vertex> path;
    private int totalWeight;

    public ShortestPath(List<Vertex> path, int totalWeight) {
        this.path = path;
        this.totalWeight = totalWeight;
    }

    public List<Vertex> getPath() {
        return path;
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}
