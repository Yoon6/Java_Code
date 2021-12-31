package pocu.midterm;

public class ShiftedArray {
    public static int findSecondMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return nums[1];
        }
//        return nums[findRecur(nums, 0, nums.length - 1) + 1];
        int index =  findRecur(nums, 0, nums.length - 1);
        if (index == nums.length - 1) {
            return nums[0];
        }
        return nums[index + 1];
    }

    public static int findRecur(int[] nums, int start, int end) {
        int mid = (start + end) / 2;

        if (start >= end) {
            return mid;
        }

        if (nums[mid] < nums[end]) {
            // 중간 부터 끝까지가 오름차순이면, 최소 인덱스는 중간을 포함해서 앞쪽에 있음

            return findRecur(nums, start, mid);
        } else {

            // 오름추순이 아니라면, 중간 다음에 최소값이 있음
            return findRecur(nums, mid + 1, end);
        }
    }

    public static void main(String[] args) {

        int[] nums = {5, 6, 1, 2, 3, 4};

        int secondMin = findSecondMin(nums);

        System.out.println("secondMin = " + secondMin);

    }
}
