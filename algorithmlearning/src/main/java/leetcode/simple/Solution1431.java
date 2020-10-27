package leetcode.simple;

import java.util.ArrayList;
import java.util.List;

public class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<Boolean>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i],max);
        }
        for (int i = 0; i < candies.length; ++i) {
            res.add(candies[i] + extraCandies >= max);
        }
        return res;
    }
}
