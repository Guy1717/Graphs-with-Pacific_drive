import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GraphTest {
    @Test
    public void testContains() {

        var graph = new Graph(true);

        Vertex A = new Vertex("A", 1);
        Vertex B = new Vertex("B", 1);
        Vertex C = new Vertex("C", 1);

        graph.vertices.add(A);
        graph.vertices.add(B);
        graph.vertices.add(C);

        assertEquals(true, graph.contains("A", "B", "C"));

    }

    @Test
    public void testAddVertex() {

        Graph graph = new Graph(true);

        graph.addVertex("A", 1);

        assertEquals("A", graph.vertices.get(0).name);
        assertEquals(1, graph.vertices.get(0).riskLevel);
    }

    @Test
    public void testAddEdge() {

        Graph graph = new Graph(true);

        Vertex A = new Vertex("A", 1);
        Vertex B = new Vertex("B", 2);

        graph.vertices.add(A);
        graph.vertices.add(B);

        graph.addEdge(A, B, 100);

        assertEquals("A", graph.edges.get(0).origin.name);
        assertEquals("B", graph.edges.get(0).destiny.name);
        assertEquals(100, graph.edges.get(0).distance);
        assertEquals(3, graph.edges.get(0).riskLevel);

    }

}
