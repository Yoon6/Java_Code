package beakjoon.tony.datastructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br1.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br1.readLine());
            String op = "";
            if (st.hasMoreTokens())
                op = st.nextToken();
            switch (op) {
                case "push":
                    if (st.hasMoreTokens()) {
                        int input = Integer.parseInt(st.nextToken());
                        stack.push(input);
                    }
                    break;
                case "pop":
                    if(!stack.isEmpty())
                        System.out.println(stack.pop());
                    else
                        System.out.println(-1);
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.empty() ? 0 : 1);
                    break;
                case "top":
                    if (!stack.isEmpty()) {
                        System.out.println(stack.peek());
                    }else{
                        System.out.println(-1);
                    }
                    break;
            }
        }
        br1.close();
    }
}
