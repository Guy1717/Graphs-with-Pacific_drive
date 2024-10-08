import java.util.Scanner;

public class Menu {

    Graph graph;
    Dijkstra dijkstra;

    /**
     * Constructs a new Menu instance and initializes a graph and Dijkstra
     * algorithm.
     *
     * @param isBidirectional indicates whether the graph should be bidirectional
     */
    public Menu(boolean isBidirectional) {
        graph = new Graph(isBidirectional);
        dijkstra = new Dijkstra(graph);
    }

    /**
     * Runs the menu, allowing the user to interact with the graph.
     * <p>
     * Continuously prompts for user input until the "Stop program" option is
     * selected.
     */
    public void run() {

        String input;
        int iterations;
        String initialVertexName;
        String finalVertexName;

        Scanner keyboard = new Scanner(System.in);

        while (true) {

            showMenu();

            int operation = keyboard.nextInt();
            keyboard.nextLine();

            switch (operation) {

                case 1: // Add vertex
                    System.out.println("How many?");
                    iterations = keyboard.nextInt();
                    keyboard.nextLine(); // Consumes the '\n' left by the last read

                    for (int i = 0; i < iterations; i++) {

                        input = keyboard.nextLine();

                        String[] splitted = input.split("_");
                        String name = splitted[0];
                        int riskLevel = Integer.parseInt(splitted[1]);

                        graph.addVertex(name, riskLevel);

                    }

                    break;

                case 2: // Add edge

                    System.out.println("How many?");
                    iterations = keyboard.nextInt();
                    keyboard.nextLine();

                    for (int i = 0; i < iterations; i++) {

                        input = keyboard.nextLine();
                        String[] info = input.split("_");
                        String origin = info[0];
                        String destiny = info[1];
                        String distanceString = info[2];

                        int distance = Integer.parseInt(distanceString);

                        graph.addEdge(origin, destiny, distance);

                    }

                    break;

                case 3: // Shortest path between...

                    System.out.println("Initial vertex: ");
                    initialVertexName = keyboard.nextLine();

                    System.out.println("Final vertex: ");
                    finalVertexName = keyboard.nextLine();

                    dijkstra.printPathByDistance(initialVertexName, finalVertexName);
                    dijkstra.printPathByRisk(initialVertexName, finalVertexName);

                    break;

                case 4: // Safest path between...

                    System.out.println("Initial vertex: ");
                    initialVertexName = keyboard.nextLine();

                    System.out.println("Final vertex: ");
                    finalVertexName = keyboard.nextLine();

                    dijkstra.printPathByRisk(initialVertexName, finalVertexName);

                    break;

                case 5: // Print vertices
                    graph.printVertices();
                    break;

                case 6: // Print edges
                    graph.printEdges();
                    break;

                case 7: // Graph info
                    System.out.println("# Graph info");
                    System.out.printf("  · %d vertices\n", graph.getTotalVertices());
                    System.out.printf("  · %d edges\n", graph.getTotalEdges());
                    break;

                case 8: // Print Adjacency

                    graph.printAdjacencyList(graph.getAdjacencyList());

                    break;

                case 0: // Stop program
                    System.out.println("Program stopped!");
                    keyboard.close();
                    return;

                default: // Case out of bounds
                    System.out.println("Invalid option, try again...");
                    break;
            }
        }

    }

    /**
     * Displays the menu options to the user.
     */
    public void showMenu() {
        System.out.println("============MENU============");
        System.out.println("1. Add vertex");
        System.out.println("2. Add edge");
        System.out.println("3. Shortest path between...");
        System.out.println("4. Safest path between...");
        System.out.println("5. Print vertices");
        System.out.println("6. Print edges");
        System.out.println("7. Graph's info");
        System.out.println("8. Adjacency List");
        System.out.println("0. Stop program");
        System.out.println("============================");
    }

}
