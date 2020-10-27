package leetcode.simple;

import java.util.HashMap;

public class Solution1512 {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer index = map.get(nums[i])+1;
                map.put(nums[i],index);
                count += index;
            }
            else {
                map.put(nums[i],0);
            }
        }
        return count;

    }
}
