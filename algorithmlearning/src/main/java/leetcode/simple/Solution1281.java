package leetcode.simple;

public class Solution1281 {

    public int subtractProductAndSum(int n) {
        int multi = 1;
        int add = 0;
        int mod;
        while ( n > 0) {
            mod = n % 10;
            multi *= mod;
            add += mod;
            n = n / 10;
        }
        return multi - add;
    }
}
