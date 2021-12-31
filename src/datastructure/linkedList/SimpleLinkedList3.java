package datastructure.linkedList;
// Definition for singly-linked list.
class SinglyListNode {
    int val;
    SinglyListNode next;
    SinglyListNode(int x) { val = x; }
}

class MyLinkedList2 {

    SinglyListNode head = null;
    int length = 0;

    /** Initialize your data structure here. */
    public MyLinkedList2() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < length) {
            SinglyListNode tmp = head;
            for(int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp.val;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
            head = new SinglyListNode(val);
            length++;
            return;
        }

        SinglyListNode newNode = new SinglyListNode(val);
        newNode.next = head;
        head = newNode;
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            head = new SinglyListNode(val);
            length++;
            return;
        }

        SinglyListNode tmp = head;
        while(tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new SinglyListNode(val);
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index <= length) {
            if (head == null) {
                head = new SinglyListNode(val);
                length++;
                return;
            }
            SinglyListNode newNode = new SinglyListNode(val);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
                length++;
                return;
            }
            SinglyListNode tmp = head;
            for (int i = 0; i < index - 1; i++){
                tmp = tmp.next;
            }
            newNode.next = tmp.next;
            tmp.next = newNode;
            length++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < length) {
            if (length == 1) {
                head = null;
                length--;
                return;
            }

            if (index == 0) {
                head = head.next;
                length--;
                return;
            }
            SinglyListNode tmp = head;

            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;

            length--;
        }
    }
}

public class SimpleLinkedList3 {
    public static void main(String[] args) {
        MyLinkedList2 obj = new MyLinkedList2();

        obj.addAtIndex(0, 10);
        obj.addAtIndex(0, 20);
        obj.addAtIndex(1, 30);
        System.out.println(obj.get(0));
        System.out.println();
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj.get(i));
        }

    }
}
