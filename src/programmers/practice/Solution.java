package programmers.practice;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        int[] arr = {0, 0, 0, 0};
        String solution = solution(arr);
        System.out.println("solution = " + solution);
    }

    public static String solution(int[] numbers) {
        String answer = "";
        Num[] numArr = new Num[numbers.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = new Num(numbers[i]);
        }
        boolean isZeroArr = true;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                isZeroArr = false;
                break;
            }
        }
        if (isZeroArr) {
            return "0";
        }

        Arrays.sort(numArr, new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                int fo1 = Integer.parseInt(o1 + "" + o2);
                int fo2 = Integer.parseInt(o2 + "" + o1);
                return fo1 - fo2;
            }
        });

        for (int i = numArr.length - 1; i >= 0; i--) {
            answer += numArr[i];
        }


        return answer;
    }
    static class Num {
        int number;
        int compare;

        Num(int number) {
            this.number = number;
            String tmp = number + "";
            while (tmp.length() <= 3) {
                tmp += tmp.substring(0, 1);
            }
            compare = Integer.parseInt(tmp);
        }

        @Override
        public String toString() {
            return  number+"";
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int progress : progresses) {
            queue.add(progress);
        }

        while (!queue.isEmpty()) {

            // 하루 일했을 때,
            for (int i = progresses.length - queue.size(); i < progresses.length; i++) {
                Integer remove = queue.remove();
                if (remove >= 100) {
                    queue.add(remove);
                } else {
                    queue.add(remove + speeds[i]);
                }
            }

            // 완료된 작업 구하기
            int workNum = 0;
            while (!queue.isEmpty() && queue.peek() >= 100) {
                queue.remove();
                workNum++;
            }
            if (workNum > 0) {
                result.add(workNum);
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
