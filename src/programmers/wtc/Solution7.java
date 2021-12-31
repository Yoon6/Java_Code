package programmers.wtc;

import java.util.Arrays;

public class Solution7 {
    public static void main(String[] args) {
        String[] arr = {"1", "234", "56789"};

        Solution7 s = new Solution7();
        String[] solution = s.solution(arr, true);
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));

    }
    public String[] solution(String[] grid, boolean clockwise) {
        String[] answer = new String[grid.length];
        
        String last = grid[grid.length - 1];
        System.out.println("Arrays.toString(grid) = " + Arrays.toString(grid));

        char[][] triangle = new char[grid.length][last.length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid.length - i - 1, i2 = 0; j < grid[i].length(); j++, i2++) {
                // 시작위치

                triangle[i][j] = grid[i].charAt(i2);
            }
        }
        print(triangle);

        if (clockwise) {
            for (int i = 0, num = 1; i < triangle.length; i++, num += 2) {
                int r = i;
                int c = 0;

                char[] tmp = new char[num];
                int tmpCount = 0;
                while (true) {
                    if (c == grid.length && r == (r + i)) {
                        break;
                    }
                    if (triangle[r][c] == 0) {
                        c++;
                    } else {
                        tmp[tmpCount] = triangle[r][c];
                        r++;
                        c++;
                        tmpCount++;
                    }
                }
                answer[i] = new String(tmp);
            }

        } else {

        }
        return answer;
    }

    private void print(char[][] answer) {
        for (char[] ints : answer) {
            System.out.print("[");
            for (char anInt : ints) {
                System.out.print(anInt==0?" ":anInt);
            }
            System.out.println("]");
        }
    }
}
