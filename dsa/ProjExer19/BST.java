package ProjExer19;

public class BST {
    private Node root;
    private int nodesChecked;

    public BST() {
        root = null;
    }

    public void insert(Software key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, Software key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key.getKey().compareTo(root.key.getKey()) < 0)
            root.left = insertRec(root.left, key);

        else if (key.getKey().compareTo(root.key.getKey()) > 0)
            root.right = insertRec(root.right, key);

        return root;
    }

    public int search(Software key) {
        nodesChecked = 0;
        return searchRec(root, key);
    }

    private int searchRec(Node root, Software key) {
        nodesChecked++;

        if (root.key.getKey().equals(key.getKey()))
            return nodesChecked;

        if (root.key.getKey().compareTo(key.getKey()) > 0)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    public void inOrderTraversal() {
        System.out.printf("%-30s %-10s %-10s %-10s%n", "Name", "Version", "Quantity", "Price");
        inOrderTraversalRec(root);
    }

    private void inOrderTraversalRec(Node root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.printf("%-30s %-10s %-10d %-10.2f%n", root.key.getName(), root.key.getVersion(),
                    root.key.getQuantity(), root.key.getPrice());
            inOrderTraversalRec(root.right);
        }
    }

    public void deleteKey(Software key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, Software key) {
        if (root == null) {
            return root;
        }

        if (key.getKey().compareTo(root.key.getKey()) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.getKey().compareTo(root.key.getKey()) > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private Software minValue(Node root) {
        Software minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
}