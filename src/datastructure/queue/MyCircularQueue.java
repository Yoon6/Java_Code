package datastructure.queue;

public class MyCircularQueue {

    int[] data;
    int head, tail;
    int size;

    public MyCircularQueue(int k) {
        data = new int[k];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (tail >= data.length) {
            tail = 0;
        }
        data[tail++] = value;

        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        head++;
        if (head >= data.length) {
            head = 0;
        }
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(2);
        System.out.println(q.enQueue(1)); // return True
        System.out.println(q.enQueue(2)); // return True
        System.out.println(q.deQueue());  // return True
        System.out.println(q.enQueue(3)); // return True
        System.out.println(q.deQueue());  // return True
        System.out.println(q.enQueue(3)); // return False
        System.out.println(q.deQueue());  // return True
        System.out.println(q.enQueue(3)); // return False
        System.out.println(q.deQueue());  // return True
        System.out.println(q.Front());
    }
}
