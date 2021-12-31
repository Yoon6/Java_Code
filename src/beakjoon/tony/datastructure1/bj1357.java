package beakjoon.tony.datastructure1;

import java.io.*;
import java.util.*;

public class bj1357 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String X = st.nextToken();
        String Y = st.nextToken();

        String revX = rev(X);
        String revY = rev(Y);

        String sum = ""+(Integer.parseInt(revX)+Integer.parseInt(revY));
        System.out.println("sum="+sum);

        System.out.println(Integer.parseInt(sum));
        br.close();
    }

    static String rev(String input) {
        char[] chArr = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chArr.length; i++) {
            int n = chArr[chArr.length - 1 - i] - '0';
            sb.append(n);
        }
        return sb.toString();
    }
}
