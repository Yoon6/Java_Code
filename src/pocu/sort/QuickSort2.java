package pocu.sort;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 1, 3, 8, 7, 4, 9, 6};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

//        IPartition part = new LomutePartition();
        IPartition part = new HoarePartition();
        int pivotPos = part.partition(arr, left, right);

        quickSort(arr, left, pivotPos - 1);
        quickSort(arr, pivotPos + 1, right);
    }
}
