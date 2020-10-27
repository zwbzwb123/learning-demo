package leetcode.middle.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        findSets(nums,0,res,new ArrayList<Integer>());
        return res;
    }

    public void findSets(int[] nums,int start,List<List<Integer>> res,List<Integer> e){
        res.add(new ArrayList<Integer>(e));
        for (int i = start; i < nums.length; i++) {
            e.add(nums[i]);
            findSets(nums,i+1,res,e);
            e.remove(e.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution78().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
