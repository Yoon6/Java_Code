package beakjoon.tony.datastructure1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int value;
    Node next = null;
    Node(int value) {this.value = value;}
}

class ImplQueue {
    int value;
    Node front, back;
    int size;

    ImplQueue() {
        front = back = null;
    }


    void push(int n) {
        Node newNode = new Node(n);
        if (size == 0) {
            front = back = newNode;
        } else {
            front.next = newNode;
            back = newNode;
        }
        size++;
    }

    int pop() {
        if (size == 0) {
            return -1;
        }
        int result = front.value;

        front = front.next;
        size--;
        return result;

    }

    int front() {
        if (size == 0) {
            return -1;
        }
        return front.value;
    }

    int back() {
        if (size == 0) {
            return -1;
        }
        return back.value;
    }

    int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class bj18258 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine());
//        ImplQueue q = new ImplQueue();
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            String op = st.nextToken();
//            switch (op) {
//                case "push":
//                    if (st.hasMoreTokens()) {
//                        int value = Integer.parseInt(st.nextToken());
//                        q.push(value);
//                    }
//                    break;
//                case "pop":
//                    bw.write(q.pop()+"\n");
//                    break;
//                case "front":
//                    bw.write(q.front()+"\n");
//                    break;
//                case "back":
//                    bw.write(q.back()+"\n");
//                    break;
//                case "size":
//                    bw.write(q.size+"\n");
//                    break;
//                case "empty":
//                    bw.write(q.empty() + "\n");
//                    break;
//            }
//        }
//        bw.flush();
//        bw.close();
//        br.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch (op) {
                case "push":
                    if (st.hasMoreTokens()) {
                        int value = Integer.parseInt(st.nextToken());
                        q.add(value);
                    }
                    break;
                case "pop":
                    if (q.size() != 0) {

                        bw.write(q.remove()+"\n");
                    }
                    bw.write(-1+"\n");
                    break;
                case "front":
                    if (q.size() != 0) {

                        bw.write(q.getFirst()+"\n");
                    } else{

                        bw.write(-1+"\n");
                    }
                    break;
                case "back":
                    if (q.size() != 0) {

                        bw.write(q.get(q.size() - 1) + "\n");
                    } else {

                        bw.write(-1+"\n");
                    }
                    break;
                case "size":
                    bw.write(q.size()+"\n");
                    break;
                case "empty":
                    bw.write((q.isEmpty() ? 1 : 0) + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
