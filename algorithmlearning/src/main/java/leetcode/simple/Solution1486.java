package leetcode.simple;

public class Solution1486 {
    public int xorOperation(int n, int start) {
        return calculate(n-1,start,0);
    }

    public int calculate(int n,int start,int sum){
        if (n == 0) {
            return start ^ sum;
        }
        else{
            int v = 2*n + start;
            return calculate(n-1,start,sum^v);
        }
    }

    public static void main(String[] args) {
        Solution1486 solution1486 = new Solution1486();
        System.out.println(solution1486.xorOperation(10,5));
    }
}
