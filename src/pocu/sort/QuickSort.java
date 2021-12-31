package pocu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 1, 3, 8, 7, 4, 9, 6};
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int start, int end) {
//        System.out.println("QuickSort.quickSort(" + Arrays.toString(arr) + ", " + start + ", " + end + ")");
        int pivot = end;
        int left = start;

        // 탈출 지점
        if (start >= end) {
            return;
        }

        // pivot 기준 정렬
        for (int i = start; i < end; i++) {
//            System.out.println("i = " + i);
            if (arr[pivot] >= arr[i]) {

                swap(arr, left, i);
//                System.out.println("swap(" + Arrays.toString(arr) + ", " + left + ", " + i + ")");
                left++;
            }
        }
        // pivot 위치 결정
        swap(arr, pivot, left);
//        System.out.println("pivot: swap(" + Arrays.toString(arr) + ", " + pivot + ", " + left + ")");

        // left가 나누는 기준값임
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);

    }
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
