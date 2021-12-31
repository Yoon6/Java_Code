package datastructure.linkedList;

class MySimpleLinkedList {
    class Node {
        int data;
        Node next = null;
        Node(int data) {
            this.data = data;
        }
    }

    Node head = new Node(0);
    Node tail = new Node(0);
    int count = 0;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if (count == 0) {
            head.next = newNode;
            tail.next = newNode;
        } else {
            newNode.next = head.next;
            head.next = newNode;
        }
        count++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (count == 0) {
            head.next = newNode;
            tail.next = newNode;
        } else {
            tail.next.next = newNode;
            tail.next = newNode;
        }
        count++;
    }

    public void add(int index, int data) {
        Node newNode = new Node(data);
        if (index <= count) {
            if (index == 0) {
                if (count == 0) {
                    head.next = newNode;
                    tail.next = newNode;
                } else {
                    newNode.next = head.next;
                    head.next = newNode;
                }
            } else {
                Node tmp = head;
                for (int i = 0; i < index; i++) {
                    tmp = tmp.next;
                }

                if (tmp != null) {
                    if (tail.next == tmp) {
                        tail.next = newNode;
                    }
                    newNode.next = tmp.next;
                    tmp.next = newNode;
                }
            }
            count++;
        }
    }

    public void delete(int index) {
        if (index < count) {
            if (index == 0 && count == 1) {
                head.next = null;
                tail.next = null;
            } else if (index == 0) {
                head.next = head.next.next;

            } else {
                Node tmp = head;
                for (int i = 0; i < index; i++) {
                    tmp = tmp.next;
                }
                if (tmp.next == tail.next) {
                    tail.next = tmp;
                }
                tmp.next = null;
            }
            count --;
        }
    }

    public int get(int index) {
        if (index < count) {
            Node tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            if (tmp.next != null) {
                return tmp.next.data;
            }
        }
        return -1;
    }

    public int size(){
        return count;
    }
}

public class SimpleLinkedList {
    public static void main(String[] args) {

        MySimpleLinkedList ll = new MySimpleLinkedList();

        ll.addFirst(11);
        ll.addFirst(1);

        System.out.println(ll.get(0));
        System.out.println(ll.get(1));
        System.out.println(ll.size());

        ll.addLast(2);
        System.out.println(ll.size());
        System.out.println(ll.get(2));
        ll.add(3, 33);
        ll.add(5, 55);

        System.out.println();
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i));
        }

        ll.delete(0);
        ll.delete(2);
        System.out.println();
        for (int i = 0; i < ll.size(); i++) {
            System.out.println(ll.get(i));
        }
    }
}
