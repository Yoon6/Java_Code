package pocu.sort;

import java.util.Arrays;

public class HoarePartition implements IPartition {

    @Override
    public int partition(int[] arr, int left, int right) {

        System.out.println("HoarePartition.partition(" + Arrays.toString(arr) + ", " + left + ", " + right + ")");
        int mid = (left + right) / 2;
        int pivot = arr[mid];
        int l = left;
        int r = right;
        System.out.println("mid = " + mid);

        // 오른쪽 포인터가 왼쪽 포인터를 넘어가면 종료
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if ((arr[l] <= pivot || l == mid)) {
                    l++;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if ((arr[r] > pivot || r == mid) && r > 0) {
                    r--;
                }
            }

            if (l >= r) {
                break;
            };

            // 각각 멈추면, 교환
            QuickSort.swap(arr, l, r);
            System.out.println("swaped(" + Arrays.toString(arr) + ", " + l + ", " + r + ")");
        }

        // pivot 위치와 left 위치 교환
        QuickSort.swap(arr, l, mid);
        System.out.println("pivot: swaped(" + Arrays.toString(arr) + ", " + l + ", " + mid + ")");

        return l;
    }
}
