package pknu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main2 {
    private static boolean[] isVisited;
    private static boolean[][] board;
    private static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        board = new boolean[n + 1][n + 1];
        isVisited = new boolean[n + 1];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            board[x][y] = true;
            board[y][x] = true;
        }
        dfs(x);

        int result = 0;
        wr.write(result + "");

        wr.flush();
    }

    public static void dfs(int index) {
        isVisited[index] = true;
        stack.push(index);

        for (int i = 1; i < board.length; i++) {
            if (board[index][i] && isVisited[i]) {
                if (index == stack.firstElement()) {
                    System.out.println("stack = " + stack);
                }
            }
            if (board[index][i] && !isVisited[i]) {
                board[i][index] = false; // 사용한 edge는 다시 사용 못하게
                dfs(i);
                board[i][index] = true;
            }
        }
    }
}
