package leetcode.jzoffer;

public class Solution45 {

    public static void main(String[] args) {
        System.out.println(new Solution45().minNumber(new int[]{10,2}));
    }
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs,0,strs.length-1);
        String res = "";
        for (String s:strs) {
            res = res + s;
        }
        return res;
    }

    private void quickSort(String[] strs, int left, int right) {
        if (left >= right)
            return;
        String t;
        int pivot = right;

        int start = left;
        int end = right;

        while (start < end) {
            while ( (strs[start]+strs[pivot]).compareTo(strs[pivot]+strs[start]) <= 0 && start < end) start++;
            while ( (strs[end]+strs[pivot]).compareTo(strs[pivot]+strs[end]) >= 0 && start < end) end--;
            t = strs[end];
            strs[end] = strs[start];
            strs[start] = t;
        }

        t = strs[pivot];
        strs[pivot] = strs[start];
        strs[start] = t;

        quickSort(strs,left,start-1);
        quickSort(strs,start+1,right);
    }
}
