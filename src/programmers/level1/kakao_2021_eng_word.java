package programmers.level1;

public class kakao_2021_eng_word {
    static class Solution {
//        enum number {zero, one, two, three, four, five, six, seven, eight, nine}
        public int solution(String s) {

            int[] digit = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            for (int i = 0; i < 10; i++) {
                s = s.replaceAll(num[i], digit[i] + "");
            }

//            int c = 0;
//            while (c < 10) {
//                int k = s.indexOf(num[c]);
//                if (k == -1) {
//                    c++;
//                } else {
//                    s = s.substring(0, k) + c + s.substring(k + num[c].length(), s.length());
//                }
//            }

            return Integer.parseInt(s);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("one4seveneight"));

    }
}
