package pocu.tree;

public class Node {
    private final int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public static Node insertRecursive(final Node node, int data) {
        if (node == null) {
            new Node(data);
        }

        if (node.data <= data) {
            node.right = insertRecursive(node.right, data);
        } else {
            node.left = insertRecursive(node.left, data);
        }

        return node;
    }

}
