package datastructure.linkedList;
class Node {
    int data;
    Node next = null;
    Node(int d) {
        this.data = d;
    }
    void append(int input) {
        Node end = new Node(input);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
    void delete(int input) {
        Node n = this;
        while (n.next != null) {
            if (n.next.data == input) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }
    void print() {
        Node n = this;
        while (n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }
}

public class LinkedList1 {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.print();
        n.append(2);
        n.append(2);
        n.append(3);
        n.print();
        n.delete(2);
        n.print();
    }
}
