package programmers.wtc;

import java.util.Arrays;

public class Solution5 {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        s.solution(3, 4);
    }
    public int[][] solution(int rows, int columns) {
        int[][] answer = new int[rows][columns];

        // 현재 위치
        int r = 0;
        int c = 0;
        int value = 1;
        answer[r][c] = value;

        while (isPossibleToWrite(answer)) {
            // 과정 수행
            if (value % 2 == 0) {
                // 이전 값이 짝수일 때,
                if (r < rows - 1) {
                    r++;
                } else {
                    // 마지막 인덱스라면 처음으로
                    r = 0;
                }
            } else {
                // 이전 값이 홀수일 때,
                if (c < columns - 1) {
                    c++;
                } else {
                    c = 0;
                }
            }

            answer[r][c] = ++value;
        }

        print(answer);

        return answer;
    }

    private boolean isPossibleToWrite(int[][] answer) {
        if (answer.length == answer[0].length) {
            // 정사각형 배열일 때,
            if (answer[answer.length - 1][0] != 0) {
                return false;
            }
        }

        // 0이 없을 때,
        for (int[] ints : answer) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    // 0이 하나라도 있으면
                    return true;
                }
            }
        }
        return false;
    }

    private void print(int[][] answer) {
        for (int[] ints : answer) {
            System.out.print("[");
            for (int anInt : ints) {
                System.out.print(" " + anInt + " ");
            }
            System.out.println("]");
        }
    }
}
