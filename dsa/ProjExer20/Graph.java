package ProjExer20;

import java.io.*;
import java.util.*;

class Graph {
    private String[] vertices;
    private String[] edges;
    private int[][] adjacencyMatrix;
    private int[][] incidenceMatrix;
    private int vertexCount = 0;
    private int edgeCount = 0;

    public void countVerticesAndEdges(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.length() == 1) {
                vertexCount++;
            } else {
                edgeCount++;
            }
        }
        reader.close();
        vertices = new String[vertexCount];
        edges = new String[edgeCount];
        adjacencyMatrix = new int[vertexCount][vertexCount];
        incidenceMatrix = new int[vertexCount][edgeCount];
    }

    public void readGraphFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int vertexIndex = 0;
        int edgeIndex = 0;
        while ((line = reader.readLine()) != null) {
            if (line.length() == 1) {
                vertices[vertexIndex++] = line;
            } else {
                String[] vertices = line.split(" ");
                int sourceIndex = Arrays.asList(this.vertices).indexOf(vertices[0]);
                int destinationIndex = Arrays.asList(this.vertices).indexOf(vertices[1]);
                adjacencyMatrix[sourceIndex][destinationIndex] = 1;
                edges[edgeIndex] = vertices[0] + "-" + vertices[1];
                incidenceMatrix[sourceIndex][edgeIndex] = 1;
                edgeIndex++;
            }
        }
        reader.close();
    }

    public void depthFirstTraversal(int startVertex) {
        boolean[] visited = new boolean[vertexCount];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        StringBuilder traversalResult = new StringBuilder();

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                traversalResult.append(vertices[currentVertex]).append("-");

                List<Integer> neighbors = getNeighbors(currentVertex);
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        if (traversalResult.length() > 0) {
            traversalResult.setLength(traversalResult.length() - 1);
        }
        System.out.println(traversalResult.toString());
    }

    private List<Integer> getNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }
}
