package beakjoon.tony.datastructure1;

import java.io.*;
import java.util.*;

public class bj10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // stack에 괄호 추가 -> 현재 영향을 받는 막대 개수
        // 레이저 인식 현재 영향을 받는 막대 개수 만큼 더해준다.
        Stack<Character> stack = new Stack<>();

        char[] input = br.readLine().toCharArray();
        int sum = 0; // 막대 조각의 합
        int count = 0; // 현재 영향 받는 막대 개수

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                stack.push('(');
                count++;
            } else {
                if (stack.peek() == '(') {
                    // 레이저
                    count--; // 레이저 괄호 빼고
                    stack.push(')');
                    sum += count;
                } else {
                    count--;
                    sum++;
                    stack.push(')');
                }
            }
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
