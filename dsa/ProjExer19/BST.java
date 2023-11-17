package ProjExer19;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> inOrderTraversal() {
        return inOrderTraversalRec(root);
    }

    private List<String> inOrderTraversalRec(Node root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inOrderTraversalRec(root.left));
            String line = root.key.getName() + ", " + root.key.getVersion() + ", " + root.key.getQuantity() + ", "
                    + root.key.getPrice();
            result.add(line);
            result.addAll(inOrderTraversalRec(root.right));
        }
        return result;
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