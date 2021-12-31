package pocu.midterm;

class Node {
    private int data;

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

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class TreeSearch {
    public static Node search(Node node, int data) {
        Node tmp = node;

        while (tmp != null) {

            if (tmp.getData() == data) {
                break;
            } else if (tmp.getData() > data) {
                // 찾으려는 데이터가 더 작으면
                tmp = tmp.getLeft();
            } else if (tmp.getData() < data) {
                tmp = tmp.getRight();
            }

        }
        return tmp;
    }

    public static Node insert(Node root, int data) {

        if (root == null) {
            return new Node(data);
        } else if (root.getData() > data) {
            root.setLeft(insert(root.getLeft(), data));
        } else {
            root.setRight(insert(root.getRight(), data));
        }
        return root;

    }
}
