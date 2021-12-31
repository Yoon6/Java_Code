package pocu.datastructure;

import java.util.Arrays;

// ring buffer
public class QueueTest {
    private int[] arr;
    private int front;
    private int back;
    private int size;

    public QueueTest(int size) {
        arr = new int[size];
        front = -1;
        back = -1;
        size = 0;
    }

    public boolean enque(int value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            arr[0] = value;
            front = 0;
            back = 0;
            size++;
            return true;
        }

        arr[++back % arr.length] = value;
        size++;
        return true;
    }

    public int deque() {
        if (isEmpty()) {
            return -1;
        }

        int result = arr[front % arr.length];
        arr[front++ % arr.length] = 0;

        size--;
        return result;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }

        return arr[front % arr.length];
    }

    public int back() {
        if (isEmpty()) {
            return -1;
        }

        return arr[back % arr.length];

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= arr.length;

    }

    public int size() {
        return size;
    }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        QueueTest q = new QueueTest(3);

        System.out.println(q.enque(1));
        System.out.println(q.enque(2));
        System.out.println(q.enque(3));
        System.out.println(q.enque(4));
        q.print();
        System.out.println(q.front());
        System.out.println(q.back());
        System.out.println(q.deque());
        System.out.println(q.deque());
        q.print();
        System.out.println(q.enque(4));
        q.print();
        System.out.println(q.back());
        q.print();
        System.out.println(q.back);
        System.out.println(q.front);

        System.out.println(q.deque());
        q.print();
        System.out.println(q.deque());
        q.print();
        System.out.println(q.deque());
    }
}
