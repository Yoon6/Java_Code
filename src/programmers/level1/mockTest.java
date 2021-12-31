package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class mockTest {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{1,2,3,4,5});

        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int[] answers) {
//        int[] answer = new int[3];
        ArrayList<Integer> arr = new ArrayList<>();

        int[] result = {
                result1(answers),
                result2(answers),
                result3(answers)
        };

        int max = Math.max(result[0], result[1]);
        max = Math.max(max, result[2]);

        for (int i = 0, k = 0; i < 3; i++) {

            if (result[i] == max) {
                arr.add(i + 1);
            }
        }
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }

    public static int result1(int[] answers) {
        int[] pattern = {1, 2, 3, 4, 5};
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[i % pattern.length]) {
                count++;
            }
        }
        return count;
    }

    public static int result2(int[] answers) {
        int[] pattern = {2, 1, 2, 3, 2, 4, 2, 5};
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[i % pattern.length]) {
                count++;
            }
        }
        return count;
    }

    public static int result3(int[] answers) {
        int[] pattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[i % pattern.length]) {
                count++;
            }
        }
        return count;
    }
}
