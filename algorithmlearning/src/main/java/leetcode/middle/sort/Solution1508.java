package leetcode.middle.sort;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1508 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Long> list = new ArrayList<Long>();
        for (int i = 0 ;i < nums.length; i++) {
            long v = nums[i];
            list.add(v);
            for (int j = i+1;j<nums.length;j++) {
                v = v+nums[j];
                list.add(v);
            }
        }
        Collections.sort(list);
        int res = 0;
        for (int i = left -1;i<right;i++) {
            res += list.get(i);
            if (res >  1000000007 ) {
                res -= 1000000007;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1508().rangeSum(
                new int[]{100,100,100,100},4,1,5
        ));
    }
}
