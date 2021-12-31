package programmers.wtc;

import java.util.HashMap;

public class Solution3 {
    public static void main(String[] args) {
        String[] ings = {"x 25", "y 20", "z 1000"};
        String[] menu = {"AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"};
        String[] sell = {"BBBB 3", "TTT 2"};
        int solution = solution(ings, menu, sell);
        System.out.println(solution);
    }
    public static int solution(String[] ings, String[] menu, String[] sell) {
        int answer = 0;
        HashMap<Character, Integer> ingMap = new HashMap<>();
        HashMap<String, Integer> menuMap = new HashMap<>();

        // 원재료 가격표
        for (String ing : ings) {
            String[] s = ing.split(" ");
            ingMap.put(s[0].charAt(0), Integer.parseInt(s[1]));
        }

        // 메뉴 : 순수익 표
        for (String menuElement : menu) {
            String[] s = menuElement.split(" ");
            int cost = 0;
            int income = Integer.parseInt(s[2]);
            for (int i = 0; i < s[1].length(); i++) {
                char c = s[1].charAt(i);
                cost += ingMap.get(c);
            }
            income -= cost;
            menuMap.put(s[0], income);
        }

        // 판매량 -> 수익 계산
        for (String s : sell) {
            String[] s1 = s.split(" ");
            int income = menuMap.get(s1[0]);
            int num = Integer.parseInt(s1[1]);

            answer += num * income;
        }

        return answer;
    }
}
