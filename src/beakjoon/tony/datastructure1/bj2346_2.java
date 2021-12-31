package beakjoon.tony.datastructure1;

import java.io.*;
import java.util.*;

public class bj2346_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<int[]> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(new int[]{i + 1, Integer.parseInt(st.nextToken())});
        }


        int[] b = list.remove(0);
        bw.write(b[0] + " ");
        while (!list.isEmpty()) {
                if (b[1] > 0) { // 풍선 내용이 양수면,
                    for (int i = 0; i < b[1] - 1; i++) {
                        list.add(list.remove(0));
                    }
                    b = list.remove(0);
                    bw.write(b[0] + " ");
                } else {
                    for (int i = 0; i < Math.abs(b[1]) - 1; i++) {
                        list.add(0, list.remove(list.size() - 1));
                    }
                    b = list.remove(list.size() - 1);
                    bw.write(b[0] + " ");
                }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
