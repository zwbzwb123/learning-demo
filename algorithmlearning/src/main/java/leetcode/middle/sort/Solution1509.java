package leetcode.middle.sort;

public class Solution1509 {
    public static void main(String[] args) {
        System.out.println(new Solution1509().minDifference(new int[]{2, 81, 95, 75, 20}));
    }

    public int minDifference(int[] nums) {
        if (nums.length <= 3)
            return 0;

        int n = nums.length;
        quickSort(nums, 0, n - 1);

        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            ret = Math.min(ret, nums[n - 4 + i] - nums[i]);
        }
        return ret;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int pivot = right;
        int start = left;
        int end = right;
        int t;
        while (start < end) {
            while (nums[start] <= nums[pivot] && start < end) start++;
            while (nums[end] >= nums[pivot] && start < end) end--;
            t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
        }

        t = nums[pivot];
        nums[pivot] = nums[start];
        nums[start] = t;

        quickSort(nums, left, start - 1);
        quickSort(nums, start + 1, right);
    }
}
