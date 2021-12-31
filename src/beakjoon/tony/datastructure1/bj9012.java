package beakjoon.tony.datastructure1;

import java.io.*;
import java.util.Stack;

public class bj9012 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            char[] s = br.readLine().toCharArray();
            for (int j = 0; j < s.length; j++) {
                if (s[j] == '(') {
                    stack.push('(');
                } else if (s[j] == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        stack.push(')');
                }
            }
            if (stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
