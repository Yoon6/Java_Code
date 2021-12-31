package programmers.wtc;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        String ss = "ababb";
        int[] solution = solution(ss);
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));

    }
    public static int[] solution(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        char first = s.charAt(0);
        char before = first;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == before) {
                count++;
            } else {
                result.add(count);
                count = 1;
                before = c;
            }
            if (i == s.length() - 1) {
                if (first == c && result.size() != 0) {
                    count += result.get(0);
                    result.remove(0);
                }
                result.add(count);
            }
        }

        int[] answer = listToIntArr(result);
        Arrays.sort(answer);
        return answer;
    }

    private static int[] listToIntArr(ArrayList<Integer> result) {
        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
