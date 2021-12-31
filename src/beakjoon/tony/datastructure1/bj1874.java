package beakjoon.tony.datastructure1;

import java.io.*;
import java.util.*;

public class bj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int i = 1;
        int cur = 0;
        while (true) {
            if (cur == N) { // 가능한 경우의 end point
                break;
            }
            if (i == (N + 1) && !stack.peek().equals(list.get(cur))) {
                break;
            }
            if (stack.isEmpty()) {
                stack.push(i);
                output.add("+\n");
                i++;
            } else {
                if (stack.peek().equals(list.get(cur))) {
                    result.add(stack.pop());
                    output.add("-\n");
                    cur++;
                } else {
                    stack.push(i);
                    output.add("+\n");
                    i++;
                }
            }
        }

        if (list.equals(result)) {
            Iterator<String> it = output.iterator();
            while (it.hasNext()) {
                bw.write(it.next());
            }
        } else {
            bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
