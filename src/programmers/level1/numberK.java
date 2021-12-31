package programmers.level1;

import java.util.*;

public class numberK {
    public static void main(String[] args) {
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(a, b);
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] arr = new int[commands.length];
        int i,j,k;
        for (int a = 0; a < commands.length; a++) {
            i = commands[a][0];
            j = commands[a][1];
            k = commands[a][2];

            int[] tmp = new int[j - i + 1];
            System.arraycopy(array, i - 1, tmp, 0, j - i + 1);

            Arrays.sort(tmp);
            System.out.println(Arrays.toString(tmp));

            arr[a] = tmp[k - 1];
        }
        return arr;
    }
}
