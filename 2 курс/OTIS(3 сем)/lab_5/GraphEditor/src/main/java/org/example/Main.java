package org.example;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class Main {
//        public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        GraphList graphList = new GraphList();
//
//        while (true) {
//            System.out.println("Options:");
//            System.out.println("1. Create a new graph");
//            System.out.println("2. Add a node to a graph");
//            System.out.println("3. Add an edge to a graph");
//            System.out.println("4. Print a graph");
//            System.out.println("5. Exit");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter the name for the new graph: ");
//                    String graphName = scanner.nextLine();
//                    graphList.graphs.add(new Graph(graphName));
//                    System.out.println("Graph " + graphName + " created.");
//                    break;
//                case 2:
//                    graphList.printGraphsNames();
//                    System.out.print("Enter the graph name: ");
//                    String nodeName = scanner.nextLine();
//                    Graph nodeGraph = findGraphByName(graphList.graphs, nodeName);
//                    if (nodeGraph != null) {
//                        System.out.print("Enter the node ID: ");
//                        String nodeId = scanner.next();
//                        nodeGraph.addNode(nodeId);
//                        System.out.println("Node " + nodeId + " added to " + nodeName);
//                    } else {
//                        System.out.println("Graph not found.");
//                    }
//                    break;
//                case 3:
//                    graphList.printGraphsNames();
//                    System.out.print("Enter the graph name: ");
//                    String edgeName = scanner.nextLine();
//                    Graph edgeGraph = findGraphByName(graphList.graphs, edgeName);
//                    if (edgeGraph != null) {
//                        System.out.print("Enter the ID of the first node: ");
//                        String vertex1 = scanner.next();
//                        System.out.print("Enter the ID of the second node: ");
//                        String vertex2 = scanner.next();
//                        edgeGraph.addEdge(vertex1, vertex2);
//                        System.out.println("Edge added to " + edgeName);
//                    } else {
//                        System.out.println("Graph not found.");
//                    }
//                    break;
//                case 4:
//                    graphList.printGraphsNames();
//                    System.out.print("Enter the graph name: ");
//                    String printGraphName = scanner.nextLine();
//                    Graph printGraph = findGraphByName(graphList.graphs, printGraphName);
//                    if (printGraph != null) {
//                        printGraph.printGraph();
//                    } else {
//                        System.out.println("Graph not found.");
//                    }
//                    break;
//                case 5:
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static Graph findGraphByName(List<Graph> graphList, String name) {
//        for (Graph graph : graphList) {
//            if (graph.getName().equals(name)) {
//                return graph;
//            }
//        }
//        return null;
//    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraphEditorGUI();
            }
        });
    }
}