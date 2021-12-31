package beakjoon.tony.datastructure1;

import java.util.*;
import java.io.*;

public class bj2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Deque<Balloon> q = new LinkedList<>();
//        Deque<int[]> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer input = new StringTokenizer(br.readLine());

        Balloon[] bArr = new Balloon[N];
        for (int i = 0; i < N; i++) {
            bArr[i] = new Balloon(i + 1, Integer.parseInt(input.nextToken()));
        }

        int cur = 0; // 가리키고 있는 위치
        int cnt = 0; // 출력한 개수
        Balloon b = bArr[cur];
        bw.write(b.num + " ");
        b.isPrinted = true;
        cnt++;
        int next = 0;
        while (cnt < N) {
            if (b.next < 0) { // 풍선 내용이 음수면
                if ((next) == Math.abs(b.next)) { // 내용 만큼 돌았으면 출력
                    b = bArr[cur];
                    b.isPrinted = true;
                    bw.write(b.num + " ");
                    cnt++;
                    next = 0;
                    continue;
                }
                if (cur-1 < 0) { // 커서가 음수로 가면 인덱스 끝으로 이동
                    cur = N-1;
                } else {
                    cur--;
                }
                if (!bArr[cur].isPrinted) { // 아직 출력되지 않았으면
                    next++;
                }


            } else { // 풍선 내용이 양수면
                if ((next) == b.next) { // 해당 노드다 하면, 출력
                    b = bArr[cur];
                    b.isPrinted = true;
                    bw.write(b.num + " ");
                    cnt++;
                    next = 0;
                    continue;
                }
                if (cur + 1 >= N) {

                    cur = 0;
                } else {
                    cur++;
                }
                if (!bArr[cur].isPrinted) {
                    next++;
                }


            }
        }

//        int[] b = q.remove();
//        bw.write(b[0] + " ");
//        while (!q.isEmpty()) {
//                if (b[1] > 0) {
//                    for (int i = 0; i < b[1] - 1; i++) {
//                        q.addLast(q.remove());
//                    }
//                    b = q.remove();
//                    bw.write(b[0] + " ");
//                } else {
//                    for (int i = 0; i < Math.abs(b[1]) - 1; i++) {
//                        q.addFirst(q.removeLast());
//                    }
//                    b = q.removeLast();
//                    bw.write(b[0] + " ");
//                }
//        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Balloon {
    int num;
    int next;
    boolean isPrinted = false;

    Balloon(int num, int next) {
        this.num = num;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Balloon{" +
                "num=" + num +
                ", next=" + next +
                ", isPrinted=" + isPrinted +
                '}';
    }
}
