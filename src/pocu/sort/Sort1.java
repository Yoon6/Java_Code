package pocu.sort;

import java.util.Arrays;

public class Sort1 {
    public static void main(String[] args) {

        int[] arr = {5, 3, 1, 3, 4, 6, 2};
        int[] sort = bubbleSort(arr);
        arr = new int[]{5, 3, 1, 3, 4, 6, 2};
        int[] selectSort = selectSort(arr);

        System.out.println(Arrays.toString(sort));
        System.out.println(Arrays.toString(selectSort));

        arr = new int[]{5, 3, 1, 3, 4, 6, 2};
        System.out.println(Arrays.toString(insertionSort(arr)));
//        int[] selectSort2 = selectSort2(arr);
//        System.out.println(Arrays.toString(selectSort2));
    }
    public static int[] bubbleSort(int[] arr) {

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }

            }
        }

        return arr;
    }


    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }

            }
        }
        return arr;
    }

    public static int[] selectSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = findMinIndex(arr, i);
            swap(arr, i, index);
        }
        return arr;
    }

    public static int findMinIndex(int[] arr, int start) {
        int index = 0;
        int min = arr[start];
        for (int i = start; i < arr.length; i++) {
            if (arr[i] <= min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
//            System.out.println("i = " + i + ", j = " + j);
            while (j > 0 && arr[j] < arr[j - 1]) {

//                System.out.println("swap(" + Arrays.toString(arr) + ", " + j + ", " + (j - 1) + ")");
                swap(arr, j, j - 1);
                j--;
            }
        }
        return arr;
    }

}
