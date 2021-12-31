package beakjoon.tony.datastructure1;

import java.io.*;
import java.util.*;

public class bj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> dq = new LinkedList<>();

        String input = br.readLine();
        int N = Integer.parseInt(input);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            input = st.nextToken();
            switch (input) {
                case "push_front":
                    if (st.hasMoreTokens()) {
                        input = st.nextToken();
                        dq.addFirst(Integer.parseInt(input));
                    }
                    break;
                case "push_back":
                    if (st.hasMoreTokens()) {
                        input = st.nextToken();
                        dq.addLast(Integer.parseInt(input));
                    }
                    break;
                case "pop_front":
                    if (dq.size() != 0) {
                        bw.write(dq.removeFirst() + "\n");
                    } else {
                        bw.write("-1" + "\n");
                    }
                    break;
                case "pop_back":
                    if (dq.size() != 0) {
                        bw.write(dq.removeLast() + "\n");
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "size":
                    bw.write(dq.size() + "\n");
                    break;
                case "empty":
                    bw.write((dq.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    if(dq.size() != 0)
                        bw.write(dq.peekFirst() + "\n");
                    else
                        bw.write("-1\n");
                    break;
                case "back":
                    if(dq.size() !=0)
                        bw.write(dq.peekLast() + "\n");
                    else
                        bw.write("-1\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
