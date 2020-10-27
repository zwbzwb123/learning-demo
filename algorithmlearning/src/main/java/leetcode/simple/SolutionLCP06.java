package leetcode.simple;

public class SolutionLCP06 {

    public int minCount(int[] coins) {
        int count = 0;
        int length = coins.length;
        for (int i = 0; i < length; i++) {
            if (coins[i] % 2 == 0)
                count += coins[i] >> 1;
            else
                count += (coins[i] >> 1) + 1;
        }
        return count;
    }
}
