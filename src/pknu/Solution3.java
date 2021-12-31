package pknu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }

        int result = detect(board);


        wr.write(result + "");
        wr.flush();
    }

    private static int detect(int[][] board) {
        boolean isMulti = false;
        boolean isPlus = false;

        isMulti = isMulti(board);
        isPlus = isPlus(board);

        if (isMulti ^ isPlus) {
            if (isMulti) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 2;
        }
    }

    private static boolean isPlus(int[][] board) {
        int n = board.length / 2;

        for (int i = 0; i < board.length; i++) {
            if (board[n][i] != 1) {
                return false;
            }
            if (board[i][n] != 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMulti(int[][] board) {
        int n = board.length / 2;
        if (board[n][n] != 1) {
            return false;
        }
        for (int i = 1; i <= n; i++) {
            if (board[n + i][n + i] != 1) {
                return false;
            }
            if (board[n + i][n - i] != 1) {
                return false;
            }
            if (board[n - i][n + i] != 1) {
                return false;
            }
            if (board[n - i][n - i] != 1) {
                return false;
            }
        }
        return true;
    }

}