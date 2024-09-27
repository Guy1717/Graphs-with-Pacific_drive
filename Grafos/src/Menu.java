import java.util.Scanner;

public class Menu {

    Graph graph;
    Dijkstra dijkstra;

    public Menu(boolean isBidirectional) {
        graph = new Graph(isBidirectional);
        dijkstra = new Dijkstra(graph);
    }

    public void run() {

        int aux;
        String input;

        Scanner keyboard = new Scanner(System.in);

        while (true) {

            showMenu();

            int operation = keyboard.nextInt();
            keyboard.nextLine();

            switch (operation) {

                case 1: // Add vertex

                    System.out.println("How many?");
                    aux = keyboard.nextInt();

                    keyboard.nextLine(); // Consumes the '\n' left by the last read

                    for (int i = 0; i < aux; i++) {
                        input = keyboard.nextLine();
                        graph.addVertex(input);
                    }

                    break;

                case 2: // Add edge

                    System.out.println("How many?");
                    aux = keyboard.nextInt();
                    keyboard.nextLine();

                    for (int i = 0; i < aux; i++) {

                        input = keyboard.nextLine();
                        String[] info = input.split("_");
                        String origin = info[0];
                        String destiny = info[1];
                        String weightString = info[2];

                        int weight = Integer.parseInt(weightString);

                        graph.addEdge(origin, destiny, weight);

                    }

                    break;

                case 3: // Print vertices
                    graph.printVertices();
                    break;

                case 4: // Print edges
                    graph.printEdges();
                    break;

                case 5: // Shortest path between...

                    System.out.println("Initial vertex: ");
                    String initialVertexName = keyboard.nextLine();

                    System.out.println("Final vertex: ");
                    String finalVertexName = keyboard.nextLine();

                    dijkstra.print(initialVertexName, finalVertexName);

                    break;

                case 6: // Graph info
                    System.out.println("# Graph info");
                    System.out.printf("  · %d vertices\n", graph.getTotalVertices());
                    System.out.printf("  · %d edges\n", graph.getTotalEdges());
                    break;

                case 7:

                    graph.printAdjacencyList(graph.getAdjacencyList());

                    break;

                case 0: // Stop program
                    System.out.println("Program stopped!");
                    keyboard.close();
                    return;

                default:
                    System.out.println("Invalid option, try again...");
                    break;
            }
        }

    }

    public void showMenu() {
        System.out.println("===========MENU===========");
        System.out.println("1. Add vertex");
        System.out.println("2. Add edge");
        System.out.println("3. Print vertices");
        System.out.println("4. Print edges");
        System.out.println("5. Shortest path between...");
        System.out.println("6. Graph's info");
        System.out.println("7. Adjacency List");
        System.out.println("0. Stop program");
        System.out.println("==========================");
    }

}
