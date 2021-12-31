package datastructure.practice;

class Node {
    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
    }

    void append(int n) { // 가장 뒤에 추가
        Node end = new Node(n);

        Node head = this;

        while (head.next != null) {
            head = head.next;
        }
        head.next = end;
    }
    void delete(int n) {
        Node head = this;
        while (head.next.data != n) { // 해당 노드 직전 노드를 알아야 삭제가 가능.
            head = head.next;
        }
        head.next = head.next.next;
    }
    void print(){
        Node head = this;
        while (head != null) { // 마지막 노드는 조건을 만족 못함.
            System.out.print(head.data + (head.next==null? "":"->"));
            head = head.next;
        }
        System.out.println();
    }
}

public class LinkedListPractice1 {
    public static void main(String[] args) {
        Node head = new Node(0);

        head.append(1);
        head.append(111);
        head.append(111);
        head.append(222);

        head.print();

        head.delete(111);
        head.print();
    }
}
