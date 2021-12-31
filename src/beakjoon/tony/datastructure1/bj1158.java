package beakjoon.tony.datastructure1;

import java.util.*;
import java.util.stream.Collectors;

public class bj1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] s = input.split(" ");

        Queue<Integer> q = new LinkedList<>();
        StringJoiner result = new StringJoiner(", ","<",">");

        for (int i = 1; i <= Integer.parseInt(s[0]); i++) {
            q.add(i);
        }


        while (!q.isEmpty()) {
            for (int i = 0; i < Integer.parseInt(s[1]) - 1; i++) {
                q.add(q.remove());
            }
            result.add(String.valueOf(q.remove()));
        }
        System.out.println(result);
    }
}
