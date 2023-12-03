package ProjExer21;

public class Node implements Comparable<Node> {
    public final String id;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Node previous;

    public Node(String id) {
        this.id = id;
    }

    public int compareTo(Node other) {
        return Double.compare(minDistance, other.minDistance);
    }
}
