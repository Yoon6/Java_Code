package beakjoon.tony.datastructure1;
import java.io.*;
import java.util.*;

public class bj1158_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(", ", "<", ">");
        ArrayList<Integer> arr = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }
//        int idx = K-1;
//
//        while (arr.size() != 1) {
//
//            int out = arr.remove(idx);
//            sj.add(String.valueOf(out));
//            idx = (idx + K - 1) % arr.size();
//
//        }
//        sj.add(String.valueOf(arr.get(0)));

        while (!arr.isEmpty()) {
            
        }

        System.out.println(sj);
    }
}
