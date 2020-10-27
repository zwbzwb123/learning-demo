package leetcode.simple;

public class Solution1480 {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i<nums.length;i++){
            nums[i] = nums[i]+sum;
            sum = nums[i];
        }
        return nums;
    }
}
