package pocu.tree;

public class BinarySearchTree {
    static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static void main(String[] args) {
        // create tree

        Node root = new Node();
        root.value = 6;

        insert(root, 4);

        insert(root, 10);
        insert(root, 8);

        System.out.println("root.right.left.value = " + root.right.left.value);
        System.out.println("root.right.left.value = " + root.right.right.value);
    }

    public static Node getNodeOrNull(Node node, int value) {
        if (node == null) { // 찾으려는 노드가 없음
            return null;
        }

        if (node.value == value) {
            return node;
        }

        if (node.value > value) {
            return getNodeOrNull(node.left, value);
        }
        return getNodeOrNull(node.right, value);
    }

    public static void insert(Node root, int value) {
        if (root.value > value) { // 루트노드가 더 크면 -> 왼쪽으로
            if (root.left == null) {
                root.left = new Node();
                root.left.value = value;
            } else {
                insert(root.left, value);
            }
        } else {
            if (root.right == null) {
                root.right = new Node();
                root.right.value = value;
            } else {
                insert(root.right, value);
            }
        }
    }

}
