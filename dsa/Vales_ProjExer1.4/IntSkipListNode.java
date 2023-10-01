public class IntSkipListNode {
    public int key;
    public IntSkipListNode[] next;

    IntSkipListNode(int i, int n) {
        key = i;
        next = new IntSkipListNode[n];
        for (int j = 0; j < n; j++)
            next[j] = null;
    }
}