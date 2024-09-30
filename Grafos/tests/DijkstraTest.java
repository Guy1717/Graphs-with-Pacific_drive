import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DijkstraTest {

    @Test
    public void testShortestPathByDistance() {

        Graph graph = new Graph(true);
        Dijkstra dij = new Dijkstra(graph);

        Vertex A = new Vertex("A", 1);
        Vertex B = new Vertex("B", 2);
        Vertex C = new Vertex("C", 3);
        Vertex D = new Vertex("D", 4);
        Vertex E = new Vertex("E", 5);

        graph.vertices.add(A);
        graph.vertices.add(B);
        graph.vertices.add(C);
        graph.vertices.add(D);
        graph.vertices.add(E);

        Edge a_b = new Edge(A, B, 10, 1);
        Edge a_c = new Edge(A, C, 5, 1);
        Edge b_d = new Edge(B, D, 2, 1);
        Edge c_d = new Edge(C, D, 9, 1);
        Edge d_e = new Edge(D, E, 1, 1);

        graph.edges.add(a_b);
        graph.edges.add(a_c);
        graph.edges.add(b_d);
        graph.edges.add(c_d);
        graph.edges.add(d_e);

        List<Vertex> vertices = new ArrayList<Vertex>();
        vertices.add(A);
        vertices.add(B);
        vertices.add(D);
        vertices.add(E);

        ShortestPath expected = new ShortestPath(vertices, 13);
        ShortestPath result = dij.shortestPathByDistance("A", "E");

        assertEquals(expected.getPath().get(0).name, result.getPath().get(0).name);
        assertEquals(expected.getPath().get(0).name, result.getPath().get(0).name);
        assertEquals(expected.getPath().get(0).name, result.getPath().get(0).name);
        assertEquals(expected.getPath().get(0).name, result.getPath().get(0).name);

        assertEquals(expected.getTotalWeight(), result.getTotalWeight());

    }

    @Test
    public void testShortestPathByRisk() {

        Graph graph = new Graph(true);
        Dijkstra dij = new Dijkstra(graph);

        Vertex A = new Vertex("A", 1);
        Vertex B = new Vertex("B", 2);
        Vertex C = new Vertex("C", 3);
        Vertex D = new Vertex("D", 4);
        Vertex E = new Vertex("E", 5);

        graph.vertices.add(A);
        graph.vertices.add(B);
        graph.vertices.add(C);
        graph.vertices.add(D);
        graph.vertices.add(E);

        Edge a_b = new Edge(A, B, 1, 10);
        Edge a_c = new Edge(A, C, 1, 5);
        Edge b_d = new Edge(B, D, 1, 2);
        Edge c_d = new Edge(C, D, 1, 9);
        Edge d_e = new Edge(D, E, 1, 1);

        graph.edges.add(a_b);
        graph.edges.add(a_c);
        graph.edges.add(b_d);
        graph.edges.add(c_d);
        graph.edges.add(d_e);

        List<Vertex> vertices = new ArrayList<Vertex>();
        vertices.add(A);
        vertices.add(B);
        vertices.add(D);
        vertices.add(E);

        ShortestPath expected = new ShortestPath(vertices, 13);
        ShortestPath result = dij.shortestPathByRisk("A", "E");

        assertEquals(expected.getPath().get(0).name, result.getPath().get(0).name);
        assertEquals(expected.getPath().get(0).name, result.getPath().get(0).name);
        assertEquals(expected.getPath().get(0).name, result.getPath().get(0).name);
        assertEquals(expected.getPath().get(0).name, result.getPath().get(0).name);

        assertEquals(expected.getTotalWeight(), result.getTotalWeight());

    }
}
