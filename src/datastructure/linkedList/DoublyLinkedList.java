package datastructure.linkedList;

import java.util.Queue;

public class DoublyLinkedList {
    DoublyLinkedNode head = null;
    DoublyLinkedNode tail = null;
    int size = 0;

    /** Initialize your data structure here. */
    public DoublyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (size == 0 || index >= size) {
            return -1;
        }
        DoublyLinkedNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (size == 0) {
            head = new DoublyLinkedNode(val);
            tail = head;
            size++;
            return;
        }
        DoublyLinkedNode newNode = new DoublyLinkedNode(val);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size == 0) {
            head = new DoublyLinkedNode(val);
            tail = head;
            size++;
            return;
        }
        DoublyLinkedNode newNode = new DoublyLinkedNode(val);

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        DoublyLinkedNode newNode = new DoublyLinkedNode(val);
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        DoublyLinkedNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        newNode.prev = cur;
        cur.next.prev = newNode;
        cur.next = newNode;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (size == 0 || index >= size) {
            return;
        }

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        DoublyLinkedNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }

        if (index == size - 1) {
            cur.next = null;
            tail = cur;
            size--;
            return;
        }

        cur.next.next.prev = cur;
        cur.next = cur.next.next;
        size--;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addAtHead(1);
//        dll.addAtTail(3);
//        dll.addAtIndex(1, 2);
        dll.deleteAtIndex(0);

        for (int i = 0; i < 6; i++) {
            System.out.println(dll.get(i));
        }
    }
}
