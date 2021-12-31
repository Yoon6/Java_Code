package pocu.search;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 5, 7, 8, 10, 15, 21, 32, 35, 39, 43, 44, 47, 99};

        int i = binarySearch(arr, 0, 15, 12);

        System.out.println(i);
    }

    public static int binarySearch(int[] arr, int first, int last, int value) {
        int mid = (first + last) / 2;

        if (first > last) {
            return -1;
        }

        if (arr[mid] != value) {
            if (arr[mid] > value) {
                mid = binarySearch(arr, first, mid - 1, value);
            } else {
                mid = binarySearch(arr, mid + 1, last, value);
            }
        }

        return mid;
    }
}
