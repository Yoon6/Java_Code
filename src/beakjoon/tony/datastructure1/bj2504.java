package beakjoon.tony.datastructure1;

import java.util.*;
import java.io.*;

public class bj2504 {
    // https://zorba91.tistory.com/151
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().trim().toCharArray();
        Stack<String> stack = new Stack<>();

        int roundBracket = 0;
        int squareBracket = 0;

        for (char c : input) {
            switch (c) {
                case '(':
                    roundBracket++;
                    stack.push("(");
                    break;
                case ')':
                    roundBracket--;
                    if (roundBracket >= 0) {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                            stack.push("2");
                        } else {
                            int sum = 0;
                            while (!stack.isEmpty()) {

                                if (stack.peek().equals("[")) {
                                    bw.write("0");
                                    bw.flush();
                                    return;
                                } else if (stack.peek().equals("(")) {
                                    stack.pop();
                                    sum *= 2;
                                    stack.push(sum + "");
                                    break;
                                } else { // 숫자면
                                    sum += Integer.parseInt(stack.pop());
                                }
                            }
                        }
                    }
                    break;
                case '[':
                    squareBracket++;
                    stack.push("[");
                    break;
                case ']':
                    squareBracket--;
                    if (squareBracket >= 0) {
                        if (stack.peek().equals("[")) {
                            stack.pop();
                            stack.push("3");
                        } else {
                            int sum = 0;
                            while (!stack.isEmpty()) {
                                if (stack.peek().equals("(")) {
                                    bw.write("0");
                                    bw.flush();
                                    return;
                                } else if (stack.peek().equals("[")) {
                                    stack.pop();
                                    sum *= 3;
                                    stack.push(sum + "");
                                    break;
                                } else {
                                    sum += Integer.parseInt(stack.pop());
                                }
                            }
                        }
                    }
                    break;
            }
            if (squareBracket < 0 || roundBracket < 0) {
                bw.write("0");
                bw.flush();
                return;
            }
        }

        if(squareBracket != 0 || roundBracket != 0) {
            bw.write("0");
            bw.flush();
            return;
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += Integer.parseInt(stack.pop());
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
