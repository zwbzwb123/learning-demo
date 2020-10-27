package leetcode.simple;

public class Solution1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int start = 0;
        for (int i = 0;i<n;i++){
            res[start++] = nums[i];
            res[start++] = nums[n+i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1470 solution1470 = new Solution1470();
        int[] shuffle = solution1470.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3);
        for (Integer i :shuffle){
            System.out.println(i);
        }
    }
}
