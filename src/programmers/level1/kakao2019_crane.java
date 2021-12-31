package programmers.level1;

import java.util.Stack;

public class kakao2019_crane {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        Solution_crane sc = new Solution_crane();
        int solution = sc.solution(board, moves);
        System.out.println(solution);
    }
}
class Solution_crane {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int answer = 0;
        for(int i=0; i<moves.length; i++){
            int selector = moves[i];
            System.out.println("selector = " + selector);
            for (int j = 0; j < board.length; j++) {
                if (!(board[j][selector-1] == 0)) {
                    int tmp = board[j][selector - 1]; // 인형 가져오기
                    board[j][selector - 1] = 0;
                    System.out.println("\ttmp = " + tmp);
                    if (st.peek() == tmp) { // 합쳐지면,
                        st.pop();
                        answer++;
                        j=board.length;
                    } else {
                        st.push(tmp);
                        j=board.length;
                    }
                    System.out.println(st);
                }
            }
        }
        return answer*2;
    }
}