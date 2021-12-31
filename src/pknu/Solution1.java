package pknu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String[] arr = br.readLine().split(" ");
        int i = 0;
        while (!isSorted(arr, i)) {
            i++;
        }
        wr.write(i + "");
        wr.flush();
    }

    private static boolean isSorted(String[] arr, int start) {
        if (start >= arr.length) {
            return false;
        }

        for (int i = start, before = 0; i < arr.length; i++) {
            int cur = Integer.parseInt(arr[i]);
            if ((cur - before) < 0) {
                return false;
            }
            before = cur;
        }

        return true;
    }
}
