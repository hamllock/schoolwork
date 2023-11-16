package ProjExer18;

public class BST {
    private BSTNode root;
    private int nodesChecked;

    public BST() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private BSTNode insertRec(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    public int search(int key) {
        nodesChecked = 0;
        return searchRec(root, key);
    }

    private int searchRec(BSTNode root, int key) {
        nodesChecked++;

        if (root == null || root.key == key)
            return nodesChecked;

        if (root.key > key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    // delete
}