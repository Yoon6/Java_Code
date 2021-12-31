package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class kakao_new_id {
    public static void main(String[] args) {
        Solution s = new Solution();
//        s.solution("...!@BaT#*..y.abcdefghijklm");
//        s.solution("=.=");

        Solution2 s2 = new Solution2();
        String ss = s2.solution("...!@BaT#*..y.abcdefghijklm");
        System.out.println(ss);
        String ss2 = s2.solution("=.=");
        System.out.println(ss2);
    }
}
class Solution{
    public String solution(String new_id){
        ArrayList<Character> list = new ArrayList<>();
        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        if (new_id.length() != 0) {
            for (int i = 0; i < new_id.length(); i++) {
                char index = new_id.charAt(i);
                if (index>='a' && index<='z') {
                    list.add(index);
                } else if (index >= '0' && index <= '9') {
                    list.add(index);
                } else if (index == '-') {
                    list.add(index);
                } else if (index == '_') {
                    list.add(index);
                } else if (index == '.') {
                    // 3단계
                    if (list.size() == 0) {
                        list.add(index);
                    } else {
                        if (!(list.get(list.size() - 1)=='.')) {
                            list.add(index);
                        }
                    }
                }
            }
        }


        // 4단계
        if (list.get(0)=='.') {
            list.remove(0);
        } else if (list.get(list.size() - 1) == '.') {
            list.remove(list.size() - 1);
        }

        // 5단계
        if (list.isEmpty()) {
            list.add('a');
        }

        // 6단계
        if (list.size() >= 16) {
            for (int i = list.size()-1; list.size() > 15; i--) {
                list.remove(i);
            }
        }


        // 7단계
        if (list.size() < 3) {
            char last = list.get(list.size() - 1);
            while (list.size() < 3) {
                list.add(last);
            }
        }

        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i);
        }
        System.out.println("str : " + str);
        return str;
    }
}

class Solution2 {

    public String solution(String new_id){

        String str = new FilteredId(new_id)
                .toLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .lessThan16()
                .noStartEndDot()
                .noLessThan2()
                .toString();
        return str;
    }

    private static class FilteredId {
        private String str = "";

        FilteredId(String str) {
            this.str = str;
        }

        private FilteredId toLowerCase() {
            str = str.toLowerCase();
            return this;
        }

        private FilteredId filter(){
            str = str.replaceAll("[^0-9a-z._-]", "");
            return this;
        }

        private FilteredId toSingleDot() {
            str = str.replaceAll("[.]{2,}", ".");
            return this;
        }

        private FilteredId noStartEndDot() {
            str = str.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private FilteredId noBlank() {
            str = str.isEmpty() ? "a" : str;
            return this;
        }

        private FilteredId lessThan16() {
            if (str.length() >= 16) {
                str = str.substring(0, 15);
            }
            return this;
        }

        private FilteredId noLessThan2(){
            StringBuilder sb = new StringBuilder(str);
            while (sb.length() <= 2) {
                sb.append(sb.charAt(sb.length() - 1));
            }
            str = sb.toString();
            return this;
        }

        @Override
        public String toString() {
            return str;
        }
    }
}