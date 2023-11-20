package ProjExer110;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        graph.readGraphFromFile("graph.txt");
        graph.displayAdjacencyList();
        graph.displayIncidenceMatrix();
    }
}
