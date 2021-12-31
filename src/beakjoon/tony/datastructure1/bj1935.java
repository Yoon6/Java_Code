package beakjoon.tony.datastructure1;

import java.io.*;
import java.util.*;

public class bj1935 {
    public static void main(String[] args) throws IOException {
        // 후위 표기식 => 일반 표기식으로 변환
        // ABC*+DE/- = A+B*C-D/E = 1 + 2*3 - 4/5

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Double> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        char[] expression = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        double sum=0, fir, sec;

        for (int i = 0; i < expression.length; i++) {
            if (expression[i] >= 'A' && expression[i] <= 'Z') {
                stack.push((double) list.get(expression[i] - 'A'));
            } else {
                sec = stack.pop();
                fir = stack.pop();
                switch (expression[i]) {
                    case '+':
                        sum = fir + sec;
                        break;
                    case '-':
                        sum = fir - sec;
                        break;
                    case '*':
                        sum = fir * sec;
                        break;
                    case '/':
                        sum = fir / sec;
                        break;
                }
                stack.push(sum);
            }

        }
        sum = (Math.floor((sum * 100))/ 100f);
        bw.write(String.format("%.2f\n",sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
