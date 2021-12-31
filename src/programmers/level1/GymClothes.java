package programmers.level1;

import java.util.Arrays;

public class GymClothes {
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {

            int max = 0;
            Arrays.sort(reserve);

            for (int i = 0; i < lost.length; i++) {

                int index = Arrays.binarySearch(reserve, lost[i]);
                if (index > -1) {
                    max++;
                    lost[i] = -1;
                    reserve[index] = -1;
                }
            }
            for (int i = 0; i < lost.length; i++) {
                if (lost[i] != -1) {
                    int index = Arrays.binarySearch(reserve, lost[i] - 1);
                    if (index > -1) {
                        max++;
                        reserve[index] = -1;
                        continue;
                    }
                    index = Arrays.binarySearch(reserve, lost[i] + 1);
                    if (index > -1) {
                        max++;
                        reserve[index] = -1;
                    }
                }
            }

            return Math.min((n - lost.length + max), n);

        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }
}
