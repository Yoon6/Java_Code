package pocu.finalterm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    class Node {
        String title;
        ArrayList<Node> children;
    }

    public static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            Node next = queue.remove();

            System.out.println(next.title);

            for (Node child : next.children) {
                queue.add(child);
            }
        }
    }
}
