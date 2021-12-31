package programmers.level1;

import java.util.*;

public class Ponketmon {
}

class Solution5 {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int possible = nums.length/2;
        if (possible > set.size()) {
            answer = set.size();
        } else {
            answer = possible;
        }

        return answer;
    }
}