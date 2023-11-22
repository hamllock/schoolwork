package ProjExer20;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        try {
            graph.countVerticesAndEdges("graph.txt"); // Replace with your file path
            graph.readGraphFromFile("graph.txt"); // Replace with your file path
            int startVertex = Arrays.asList(graph.getVertices()).indexOf("A");
            if (startVertex != -1) {
                graph.depthFirstTraversal(startVertex);
            } else {
                System.out.println("Start vertex not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
