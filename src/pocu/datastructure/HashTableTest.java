package pocu.datastructure;

import java.util.LinkedList;

class HashTable {
    class Node {
        private String key;
        private String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private LinkedList<Node>[] data;

    public HashTable(int size) {
        data = new LinkedList[size];
    }

    // 해시함수
    private int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    // 해시 값을 인덱스로 변환
    private int convertToIndex(int hashCode) {
        return hashCode % data.length;
    }

    private Node searchByKey(LinkedList<Node> list, String key) {
        if (list == null) {
            return null;
        }

        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }

        return null;
    }

    public void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];

        if (list == null) {
            list = new LinkedList<>();
            data[index] = list; // 리스트가 없으면, 만들어서 할당
        }
        Node node = searchByKey(list, key);
        if (node == null) {
            list.add(new Node(key, value));
        } else {
            node.setValue(value);
        }
    }

    public String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];
        Node node = searchByKey(list, key);
        return node == null ? "Not Found" : node.getValue();
    }
}
public class HashTableTest {
    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("park", "isn't she lovely?");
        h.put("jin", "isn't he wonderful?");
        h.put("ddalgi", "what a cuty puppy");
        h.put("dalrae", "more beautiful puppy");
        System.out.println(h.get("park"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("ddalgi"));
        System.out.println(h.get("dalrae"));
    }
}
