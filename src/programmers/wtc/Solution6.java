package programmers.wtc;

public class Solution6 {
    public static void main(String[] args) {
        String[][] arr = {{"홍콩", "12AM", "11PM"}, {"엘에이", "12PM", "12PM"}};
        Solution6 s = new Solution6();
        String solution = s.solution(10, arr);
        System.out.println("solution = " + solution);
    }
    public String solution(double time, String[][] plans) {
        String answer = "";

        int minute = (int) (time * 60);

        for (String[] plan : plans) {
            int consumptionTime = calculateConsumptionTime(plan[1], plan[2]);
            if (minute >= consumptionTime) {
                answer = plan[0];
                minute -= consumptionTime;
            }
            System.out.println("consumptionTime = " + consumptionTime);
            System.out.println("minute = " + minute);
            System.out.println("answer = " + answer);
        }

        return answer;
    }

    private int calculateConsumptionTime(String friday, String monday) {
        int sum = 0; // 분단위

        // 12AM - 0시
        // 12PM - 12시

        // 금요일 휴가 시간 계산
        String time = friday.substring(friday.length() - 2, friday.length());
        int hour = Integer.parseInt(friday.substring(0, friday.length() - 2));
        if (time.equals("PM")) {
            // 오후 출발
            // 근무시간 중 출발하는 경우, 휴가 사용
            if (hour < 6) {
                // 1,2,3,4,5
                sum += (6 - hour) * 60;
            } else if (hour == 12) {
                // 12
                sum += 300;
            }
        } else {
            // 오전 출발
            if (hour <= 9 || hour == 12) {
                // 12,1,2,3,4,5,6,7,8,9
                // 출근 전에 출발
                // 하루 전체 휴가
                sum += 450;
            } else {
                // 10, 11
                // 출근 하고 출발
                // 전체 근무시간 - 일한 시간
                sum += 450 - (int) ((hour - 9.5) * 60);
            }
        }


        // 월요일 휴가 시간 계산
        time = monday.substring(monday.length() - 2, monday.length());
        hour = Integer.parseInt(monday.substring(0, monday.length() - 2));
        if (time.equals("PM")) {
            // 오전 도착은 휴가 안써도 됨

            // 오후 도착
            // 12PM은 그냥 출근하면 되니까 포함 안시킴
            if (hour < 12) {
                // 1,2,3,4,5,6,7,8,9,10,11
                if (hour >= 6) {
                    // 6,7,8,9,10,11
                    // 6시 넘어가면 풀 휴가
                    sum += 300;
                } else {
                    // 1,2,3,4,5
                    // 1시에는 휴가 안써도 됨.
                    sum += (hour - 1) * 60;
                }
            }
        }
        // 더해서 반환

        return sum;
    }
}
