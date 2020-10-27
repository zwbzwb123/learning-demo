package leetcode.simple;

public class Solution461 {
    public static int hammingDistance(int x, int y) {
        int xm, ym, count = 0;
        while (x != 0 && y != 0) {
            xm = x % 2;
            x = x / 2;

            ym = y % 2;
            y = y / 2;
            if (ym != xm)
                count++;
        }
        if (x == 0)
            x = y;
        while (x > 0){
            if (x % 2 == 1)
                count++;
            x = x / 2;
        }
        return count;


       //  return Integer.bitCount( x ^ b);
    }
}
