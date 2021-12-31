package pocu.finalterm;

import java.util.HashMap;

public class Kruskal {
}

class DisjointSet {
    public final class Point {
        private final int x;
        private final int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d]", x, y);
        }

    }

    class SetNode{
        private String parent;
        private int size;

        public SetNode(String parent, int size) {
            this.parent = parent;
            this.size = size;
        }
    }

    private HashMap<String, SetNode> sets = new HashMap<>();

    public DisjointSet(Point[] points) {
        for (Point point : points) {
            sets.put(point.toString(), new SetNode(point.toString(), 1));
        }
    }

    public String find(String node) {
        SetNode setNode = sets.get(node);
        if (setNode.parent.equals(node)) {
            return node;
        }

        setNode.parent = find(setNode.parent);
        return setNode.parent;
    }

    public void union(String node1, String node2) {

        String root1 = find(node1);
        String root2 = find(node2);

        if (root1.equals(root2)) {
            return;
        }

        SetNode n1 = sets.get(root1);
        SetNode n2 = sets.get(root2);

        n2.parent = n1.parent;
        n1.size = n1.size + n2.size;
    }
}