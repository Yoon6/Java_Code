package pocu.midterm;

import java.util.Arrays;

public class ReverseArray {
    public static void reverse(char[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            char tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        reverse(arr);

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

    }
}
