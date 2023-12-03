package ProjExer21;

import java.util.*;

public class Djikstras {
    public static void computePaths(Node source) {
        source.minDistance = 0.;
        PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>();
        nodeQueue.add(source);

        while (!nodeQueue.isEmpty()) {
            Node u = nodeQueue.poll();

            for (Edge e : u.adjacencies) {
                Node v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    nodeQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    nodeQueue.add(v);
                }
            }
        }
    }

    public static List<Node> getShortestPathTo(Node target) {
        List<Node> path = new ArrayList<Node>();
        for (Node node = target; node != null; node = node.previous)
            path.add(node);

        Collections.reverse(path);
        return path;
    }
}