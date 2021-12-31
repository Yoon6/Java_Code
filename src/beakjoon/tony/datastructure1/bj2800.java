package beakjoon.tony.datastructure1;

import java.io.*;
import java.util.*;

public class bj2800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        // 괄호의 시작과 끝인덱스 쌍을 모두 기록
        // 하나씩 건너뛰면서 출력

        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<Integer> bracketList = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        // 괄호 위치 검출
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                bracketList.add(i);
            } else if (input[i] == ')') {
                bracketList.add(i);
            }
        }
        System.out.println(bracketList);

        int count = bracketList.size() / 2; // 괄호 개수
        for (int i = 0; i < count; i++) {// (i+1) = 괄호를 빼는 개수,
            char[] tmp = input;
            for (int j = 0; j < count; j++) {

                for (int k = 0; k < input.length; k++) {
                    if (bracketList.get(j) == k || bracketList.get(bracketList.size() - j - 1) == k) {
                        tmp[k] = ' ';
                    }
                    System.out.println("j=" + j + ", k=" + k);
                    System.out.println(Arrays.toString(tmp));
                }

            }
            sb = new StringBuilder();
            for (char c : tmp) {
                if (c != ' ') {
                    sb.append(c);
                }
            }
            result.add(sb.toString());
        }

        Collections.sort(result);

        System.out.println(result);

        bw.close();
        br.close();
    }
}

