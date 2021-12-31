package programmers.wtc;

public class Solution2 {
    public static void main(String[] args) {
        String[] arr = {"01:00", "01:05", "15:00", "15:04", "16:00", "19:00", "23:00", "23:59"};
        String solution = solution(arr);
        System.out.println("solution = " + solution);
    }
    public static String solution(String[] log) {
        String answer = "";
        int sumMin = 0;
        for (int i = 0; i < log.length; i += 2) {
            int beforeHour = Integer.parseInt(log[i].substring(0, 2));
            int beforeMin = Integer.parseInt(log[i].substring(3, 5));

            int afterHour = Integer.parseInt(log[i + 1].substring(0, 2));
            int afterMin = Integer.parseInt(log[i + 1].substring(3, 5));

            int totalMin = (afterHour * 60 + afterMin) - (beforeHour * 60 + beforeMin);

            if (totalMin >= 5) {
                if (totalMin >= 105) {
                    sumMin += 105;
                } else {
                    sumMin += totalMin;
                }
            }
        }
        answer = minuteToFormattedHour(sumMin);

        return answer;
    }

    private static String minuteToFormattedHour(int sumMin) {
        int hour = sumMin / 60;
        sumMin %= 60;
//        while (sumMin >= 60) {
//            hour++;
//            sumMin -= 60;
//        }
        return String.format("%2d:%2d", hour, sumMin).replace(' ', '0');

    }
}
