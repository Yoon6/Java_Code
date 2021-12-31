package datastructure.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueTest1 {

    List<Integer> data;
    int head;

    public QueueTest1() {
        data = new ArrayList<>();
        head = 0;
    }
    public boolean enQueue(int n) {
        data.add(n);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head++;
        return true;
    }

    public int Front(){
        return data.get(head);
    }

    public boolean isEmpty() {
        return head >= data.size();
    }

    public static void main(String[] args) {
        QueueTest1 q = new QueueTest1();
        q.enQueue(5);
        q.enQueue(3);
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.Front());
        }
    }
}
