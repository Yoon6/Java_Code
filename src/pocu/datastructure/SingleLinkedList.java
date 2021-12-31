package pocu.datastructure;

public class SingleLinkedList {
    static class Node {
        private int value;
        private Node next;

        public Node() {
            this.value = 0;
            this.next = null;
        }
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    private int size;

    public SingleLinkedList() {
        head = new Node();
        size = 0;
    }

    public boolean addToLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head.next = newNode;
            size++;
            return true;
        }

        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = newNode;
        size++;
        return true;
    }

    public boolean addToIndex(int index, int value) {
        if (index > size) {
            return false;
        }
        Node newNode = new Node(value);
        // 인덱스 값 바로 전의 노드를 선택해야함.
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        newNode.next = tmp.next;
        tmp.next = newNode;
        size++;
        return true;
    }

    public boolean addToFirst(int value) {
        Node newNode = new Node(value);

        newNode.next = head.next;
        head.next = newNode;
        size++;

        return true;

    }

    public boolean removeAtFirst() {
        if (isEmpty()) {
            return false;
        }

        head.next = head.next.next;
        size--;
        return true;
    }

    public boolean removeAtIndex(int index) {
        // 삽입은 마지막요소 뒤에 삽입할 수 있으나, 삭제는 요소 뒤를 삭제하지 않기 때문에 사이즈이하로 정해줌.
        if (isEmpty() || index >= size) {
            return false;
        }

        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        tmp.next = tmp.next.next;
        size--;
        return true;
    }

    public boolean removeAtLast() {
        if (isEmpty()) {
            return false;
        }

        // 마지막 노드 바로 전 노드를 선택해야함
        Node tmp = head;
        for (int i = 0; i < size - 1; i++) {
            tmp = tmp.next;
        }

        tmp.next = null;
        size--;

        return true;
    }

    public int get(int index) {
        if (isEmpty()) {
            return -1;
        }
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.next.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(this.get(i) + (i < size - 1 ? "->" : "\n"));
        }
    }
    public static void main(String[] args) {
        SingleLinkedList ll = new SingleLinkedList();

        ll.addToLast(1);
        ll.addToLast(2);
        ll.addToLast(3);

        ll.print();

        ll.removeAtLast();
        ll.removeAtLast();
        ll.removeAtLast();

        ll.print();

        ll.addToFirst(1);
        ll.addToFirst(0);
        ll.addToLast(4);
        ll.print();
        ll.addToIndex(2, 2);
        ll.addToIndex(3, 3);
        ll.print();

        ll.removeAtFirst();
        ll.print();

        ll.removeAtLast();
        ll.print();

        ll.removeAtIndex(1);
        ll.print();
//        ll.removeAtFirst();
        ll.removeAtLast();
        ll.print();
//        ll.removeAtLast();
        ll.removeAtFirst();
        ll.print();

    }
}
