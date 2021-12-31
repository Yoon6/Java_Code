package beakjoon.tony.datastructure1;

import java.io.*;
import java.util.*;

public class bj2164 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= N; i++) {
            q.addLast(i);
        }

        while (q.size() != 1) {
            removeTop(q);
            moveCardDown(q);
        }

        bw.write((Integer)q.toArray()[0]+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void removeTop(Deque<Integer> q) {
        q.removeFirst();
    }

    public static void moveCardDown(Deque<Integer> q) {
        int i = q.removeFirst();
        q.addLast(i);
    }
}
