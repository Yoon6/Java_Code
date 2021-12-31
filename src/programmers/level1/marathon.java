package programmers.level1;

import java.lang.reflect.Array;
import java.util.*;
public class marathon {
    public static void main(String[] args) {
        Solution4 sol = new Solution4();
        String solution = sol.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
        System.out.println(solution);
    }
}
class Solution4 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

//        HashMap 이용
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : participant)
            map.put(s, map.getOrDefault(s, 0) + 1);
        for(String s : completion)
            map.put(s, map.get(s) - 1);

        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> it = set.iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> e = it.next();
            if (map.get(e.getKey()) != 0) {
                answer = e.getKey();
            }
        }

//        ArrayList, LinkedList 사용
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//
//        LinkedList<String> part = new LinkedList<>(Arrays.asList(participant));
//        LinkedList<String> comp = new LinkedList<>(Arrays.asList(completion));
//
//        System.out.println(part);
//        Iterator<String> it = comp.iterator();
//        while (it.hasNext()) {
//            String tmp = it.next();
//            part.remove(tmp);
//        }
//        answer = part.get(0);
//        System.out.println(part.get(0));

//        배열 사용 - 시간초과

//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        for (String s : completion) {
//            for (int i = 0; i < participant.length; i++) {
//                if (s.equals(participant[i])) {
//                    participant[i] = "";
//                    break;
//                }
//            }
//
//            int idx = Arrays.binarySearch(participant, s);
//            System.out.println(Arrays.toString(participant));
//            System.out.println("idx=" + idx);
//            if (idx >= 0) {
//                participant[idx] = "";
//            }
//        }
//
//        for (int i = 0; i < participant.length; i++) {
//            if (!participant[i].equals("")) {
//                answer = participant[i];
//            }
//        }



        return answer;
    }
}