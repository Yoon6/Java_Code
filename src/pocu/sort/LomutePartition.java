package pocu.sort;


public class LomutePartition implements IPartition{
    @Override
    public int partition(int[] arr, int left, int right) {

        int pivot = arr[right];

        int leftPointer = left - 1;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                leftPointer++;
                QuickSort.swap(arr, leftPointer, i);

            }
        }

        QuickSort.swap(arr, right, leftPointer + 1);

        return leftPointer + 1;
    }
}
