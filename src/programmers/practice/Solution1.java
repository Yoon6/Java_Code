package programmers.practice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        String[][] str = {
                {"crow_mask", "안경"}, {"blue_sunglasses", "모자"}, {"smoky_makeup", "상의"},
                {"crow_mask", "아우터"}, {"blue_sunglasses", "양말"}
        };
        int solution = solution(str);
        System.out.println("solution = " + solution);
    }

    public static ArrayList<ArrayList<Integer>> combList;

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];
            Integer integer = map.get(category);
            if (integer == null) {
                map.put(category, 1);
            } else {
                map.put(category, map.get(category) + 1);
            }
        }

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            Integer num = map.get(s);
            int tmp = num + 1;
            answer *= tmp;
        }


//        String[] keys = keySet.toArray(new String[keySet.size()]);
//
//        boolean[] visited = new boolean[keys.length];
//        for (int j = 1; j <= keys.length; j++) {
//            combList = new ArrayList<>();
//            combination(keys, visited, 0, keys.length, j);
//            for (ArrayList<Integer> list : combList) {
//                int tmp = 1;
//                for (int i = 0; i < list.size(); i++) {
//                    tmp *= map.get(keys[list.get(i)]);
//                }
//                answer += tmp;
//            }
//        }

        return answer - 1;
    }


    static void combination(String[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    list.add(i);
                }
            }
            combList.add(list);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
