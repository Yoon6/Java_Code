package programmers.level1;

import java.util.Arrays;

public class dev_matching_2021_lotto {
    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            Arrays.sort(lottos);
            Arrays.sort(win_nums);

            int correct = 0;
            int zero = 0;

            for (int i = 0; i < 6; i++) {
                if (Arrays.binarySearch(win_nums, lottos[i]) > -1) {
                    correct++;
                } else if (lottos[i] == 0) {
                    zero++;
                }
            }
            int max = correct + zero;
            int min = correct;

            int[] answer = {(7 - max) > 5 ? 6 : (7 - max), (7 - min) > 5 ? 6 : (7 - min)};
            return answer;
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})));
    }
}
