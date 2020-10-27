package leetcode.middle.sort;

import java.util.Arrays;

public class Solution1561 {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int left = 0;
        int right = piles.length -1;
        int result = 0;

        while (left < right) {
            left ++;
            right--;
            result += piles[right --] ;
        }
        return result;
    }
}
