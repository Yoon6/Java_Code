package programmers.wtc;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 3, 3};
        int[] solution = solution(arr);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(int[] arr) {
        int[] nums = new int[3];
        int[] result = new int[3];
        for (int i : arr) {
            nums[i - 1]++;
        }

        for (int i = 0; i < nums.length; i++) {
             result[i] = nums[i];
        }

        Arrays.sort( result);
        int max =  result[2];
        for (int i = 0; i <  result.length; i++) {
             result[i] = max - nums[i];
        }


        return  result;
    }
}
