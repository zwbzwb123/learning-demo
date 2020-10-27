package leetcode.middle.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution0804 {


    public static void main(String[] args) {
        System.out.println(new Solution0804().subsets(new int[]{1, 2, 3}));
    }
    public List<List<Integer>> subsets(int[] nums) {

        int length = nums.length;
        List<List<Integer>>  res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        backtrace(nums,res,out,0,length);
        return res;
    }

    private void backtrace(int[] nums,List<List<Integer>> res, List<Integer> out,int start , int length) {
        res.add(new ArrayList<>(out));
        for (int i = start; i < length; i++) {
            out.add(nums[i]);
            backtrace(nums,res, out, i + 1,length);
            out.remove(out.size() - 1);
        }
    }
}
