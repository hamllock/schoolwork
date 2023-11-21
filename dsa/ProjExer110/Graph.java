package ProjExer110;

import java.io.*;
import java.util.*;

class Graph {
    private Map<String, List<String>> adjacencyList = new HashMap<>();
    private Map<String, Map<String, Integer>> incidenceMatrix = new HashMap<>();
    private List<String> edges = new ArrayList<>();

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
        incidenceMatrix.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(String source, String destination) {
        adjacencyList.get(source).add(destination);
        String edge = source + "-" + destination;
        edges.add(edge);
        incidenceMatrix.putIfAbsent(source, new HashMap<>());
        incidenceMatrix.get(source).put(edge, 1);
    }

    public void readGraphFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.length() == 1) {
                addVertex(line);
            } else {
                String[] vertices = line.split(" ");
                addEdge(vertices[0], vertices[1]);
            }
        }
        reader.close();
    }

    public void displayAdjacencyList() {
        System.out.print("   ");
        for (String vertex : adjacencyList.keySet()) {
            System.out.printf("%-3s", vertex);
        }
        System.out.println();
        for (String vertex : adjacencyList.keySet()) {
            System.out.printf("%-3s", vertex);
            for (String otherVertex : adjacencyList.keySet()) {
                System.out.printf("%-3d", adjacencyList.get(vertex).contains(otherVertex) ? 1 : 0);
            }
            System.out.println();
        }
    }

    public void displayIncidenceMatrix() {
        System.out.print("   ");
        for (String edge : edges) {
            System.out.printf("%-5s", edge);
        }
        System.out.println();
        for (String vertex : adjacencyList.keySet()) {
            System.out.printf("%-3s", vertex);
            for (String edge : edges) {
                if (edge.contains(vertex)) {
                    System.out.printf("%-5d", 1);
                } else {
                    System.out.printf("%-5d", 0);
                }
            }
            System.out.println();
        }
    }
}
