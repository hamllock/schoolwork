package ProjExer20;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        String filename = "graph.txt";
        graph.countVerticesAndEdges(filename);
        graph.readGraphFromFile(filename);
        graph.depthFirstTraversal(0);
    }
}
