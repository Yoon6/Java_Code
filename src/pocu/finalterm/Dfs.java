package pocu.finalterm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Dfs {
    class Node {
        String title;
        ArrayList<Node> children;
    }

    private static HashSet<String> discovered;
    private static HashSet<String> visited;
    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public static void dfs(Node node) {
        Stack<Node> stack = new Stack<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            Node next = stack.pop();

            System.out.println(next.toString());

            for (Node child : next.children) {
                stack.push(child);
            }
        }
    }

    public static void dfsRecur(Node node) {
        if (visited.contains(node.title)) {
            return;
        }

        System.out.println(node.title);
        visited.add(node.title);

        for (Node child : node.children) {
            dfsRecur(child);
        }

    }

    public static void dfsRecurReverse(Node node) {

        if (visited.contains(node.title) || discovered.contains(node.title)) {
            return;
        }

        discovered.add(node.title);

        for (Node child : node.children) {
            dfsRecurReverse(child);
        }

        System.out.println(node.title);
        visited.add(node.title);
    }
}
