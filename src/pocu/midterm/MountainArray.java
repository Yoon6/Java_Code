package pocu.midterm;

public class MountainArray {
    public static int findMax(int[] arr) {
        return arr[findRecur(arr, 0, arr.length - 1)];
    }

    public static int findRecur(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (start >= end) {
            return mid;
        }
        if (arr[mid] <= arr[mid + 1]) {
            // 증가추세
            return findRecur(arr, mid + 1, end);
        } else {
            return findRecur(arr, start, mid);
        }
    }
    // 올라갔다 내려가는 배열에서 최대값, 인덱스 찾기
    public static void main(String[] args) {
        int[] altitudes = new int[]{1, 2, 3, 4, 5, 6, 7, 4, 3, 2};
        System.out.println(findMax(altitudes));

        altitudes = new int[] {1, 2, 3, 4, 3, 0 };
        System.out.println(findMax(altitudes));
        altitudes = new int[] {4, 5, 4, 3, 2 };
        System.out.println(findMax(altitudes));
        altitudes = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println(findMax(altitudes));
        altitudes = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(findMax(altitudes));
    }
}
