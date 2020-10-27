package leetcode.middle.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution46 {

    public static void main(String[] args) {
        System.out.println(new Solution46().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0)
            return res;

        int length = nums.length;

        List<Integer> record = new ArrayList<>(length);

        for (int i = 0;i <length;i++)
            record.add(nums[i]);


        backtrace(res, record, length, 0);

        return res;
    }

    private void backtrace(List<List<Integer>> res, List<Integer> record, int length, int index) {
        if (index == length) {
            res.add(new ArrayList<>(record));
            return;
        }

        for (int i = index; i < length; i++) {
            Collections.swap(record, index, i);

            backtrace(res, record, length, index + 1);

            Collections.swap(record, index, i);
        }
    }
}
