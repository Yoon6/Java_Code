package beakjoon.tony.datastructure1;
import java.io.*;
import java.util.*;

public class bj2504_3 {

    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        String bracket = st.nextToken();
        Stack<String> stack = new Stack<>();
        int roundBracket = 0;
        int squareBracket = 0;

        for(int i=0; i<bracket.length(); i++) {

            switch (bracket.charAt(i)) {

                case '(':
                    roundBracket++;
                    stack.push("(");
                    break;
                case ')':
                    roundBracket--;
                    if(roundBracket > -1) {

                        if(stack.peek().equals("(")) {
                            stack.pop();
                            stack.push("2");
                        }else {
                            int roundResult = 0;

                            while(!stack.isEmpty()) {

                                if(stack.peek().equals("[")) {
                                    bw.write("0");
                                    bw.flush();
                                    return;
                                }else if(stack.peek().equals("(")) {
                                    stack.pop();
                                    roundResult *=2;
                                    stack.push(String.valueOf(roundResult));
                                    break;
                                }else {
                                    roundResult += Integer.parseInt(stack.pop());
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

                    if(squareBracket > -1) {
                        if(stack.peek().equals("[")) {
                            stack.pop();
                            stack.push("3");
                        }else {
                            int squareResult = 0;

                            while(!stack.isEmpty()) {

                                if(stack.peek().equals("(")) {
                                    bw.write("0");
                                    bw.flush();
                                    return;
                                }else if(stack.peek().equals("[")) {
                                    stack.pop();
                                    squareResult *=3;
                                    stack.push(String.valueOf(squareResult));
                                    break;
                                }else {
                                    squareResult += Integer.parseInt(stack.pop());
                                }
                            }
                        }
                    }
                    break;
            }

            if(squareBracket < 0 || roundBracket < 0) {
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

        int output = 0;

        while(!stack.isEmpty()) {
            output += Integer.parseInt(stack.pop());
        }

        bw.write(String.valueOf(output));
        bw.flush();
    }

}