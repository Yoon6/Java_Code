package beakjoon.tony.datastructure1;

import java.io.*;
import java.util.*;

public class bj1966 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            Queue<Prior> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int cnt = 1; // 출력하면 +1
            for (int k = 0; k < N; k++) {
                Prior pr = new Prior(k, Integer.parseInt(st.nextToken()));
                queue.add(pr);
            }

            while (!queue.isEmpty()) {
                Prior pr = queue.remove();
                if (hasUpperThan(queue, pr)) {
                    queue.add(pr);
                } else { // 출력
                    if (pr.num == M) {
                        break;
                    }
                    cnt++;
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean hasUpperThan(Queue<Prior> q, Prior prior) {// 나보다 큰게 있으면 true
        Iterator<Prior> it = q.iterator();
        int pnum = prior.priority;
        while (it.hasNext()) {
            if (it.next().priority > pnum) {
                return true;
            }
        }
        return false;
    }
}
class Prior{
    int num;
    int priority;

    Prior(int num, int priority) {
        this.num = num;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Prior{" +
                "num=" + num +
                ", priority=" + priority +
                '}';
    }
}