package datastructure.linkedList;

class DoublyLinkedNode {
    int value;
    DoublyLinkedNode prev, next;
    DoublyLinkedNode(int value) {this.value = value;}
}

class MyLinkedList {
    DoublyLinkedNode head = null;

    public MyLinkedList() {
    }

    public int get(int index) {
        if(head == null)
            return -1;

        DoublyLinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            if(cur.next == null)
                return -1;
            cur = cur.next;
        }
        return cur.value;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new DoublyLinkedNode(val);
            return;
        }

        DoublyLinkedNode newNode = new DoublyLinkedNode(val);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new DoublyLinkedNode(val);
            return;
        }
        DoublyLinkedNode newNode = new DoublyLinkedNode(val);
        DoublyLinkedNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        newNode.prev = cur;
    }

    public void addAtIndex(int index, int val) {
        if (head == null) {

            if (index == 0) {
                head = new DoublyLinkedNode(val);
            }
            return;
        }

        DoublyLinkedNode newNode = new DoublyLinkedNode(val);
        DoublyLinkedNode cur = head;
        
        for (int i = 0; i < index; i++) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }

        if(cur.prev == null) { // 젤 앞의 노드면
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else { // 젤 뒤의 노드면
            cur.prev.next = newNode;
            newNode.prev = cur.prev;
            newNode.next = cur;
            cur.prev = newNode;
        }

    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        DoublyLinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next == null) {
                return;
            }
            cur = cur.next;
        }
        if (cur == head) { // 첫 노드면
            System.out.println("kkk");
            head = cur.next;
//            cur.next.prev = cur.prev;
        } else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
    }

}

public class LinkedList2 {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        for (int i=0; i<10; i++){
            System.out.println(list.get(i));
        }
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        list.get(4);
        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);
        for (int i=0; i<10; i++){
            System.out.println(list.get(i));
        }
    }
}
