package leetcode.middle.sort;

public class Solution75 {

    public static void main(String[] args) {
        int[] a = new int[]{2, 0, 2, 1, 1, 0};
        new Solution75().sortColors(
                a
        );
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public void sortColors(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        for (int i = 0; i < length; i++) {
            while (i <= right && nums[i] == 2) {
                swap(nums, i, right--);
            }
            if (nums[i] == 0) {
                swap(nums,left++,i);
            }
        }
    }

    private void swap(int[] nums, int t, int i) {
        int temp = nums[t];
        nums[t] = nums[i];
        nums[i] = temp;
    }
}
