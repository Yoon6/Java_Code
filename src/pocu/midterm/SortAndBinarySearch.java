package pocu.midterm;

import java.util.Arrays;

public class SortAndBinarySearch {
    public static int binarySearch(int[] arr, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (start > end) {
            return -1;
        }
        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] > target) {
            // 타겟 값보다 크다면
            return binarySearch(arr, start, mid - 1, target);
        }
        return binarySearch(arr, mid + 1, end, target);

    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];

            int k = i;
            while (k > 0 && arr[k - 1] > arr[k]) {
                int tmp = arr[k];
                arr[k] = arr[k - 1];
                arr[k - 1] = tmp;
                k--;
            }
        }
    }

    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = partition(arr, start, end);

        quickSort(arr, start, mid - 1);
        quickSort(arr, mid + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = end;
        int left = start;

        for (int i = start; i < end; i++) {
            if (arr[pivot] >= arr[i]) {
                swap(arr, i, left);
                left++;
            }
        }
        swap(arr, pivot, left);

        return left;
    }


    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 4, 3, 2};
//        selectSort(arr);
//        insertSort(arr);
//        bubbleSort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));

        System.out.println(binarySearch(arr, 0, arr.length - 1, 3));

    }
}
