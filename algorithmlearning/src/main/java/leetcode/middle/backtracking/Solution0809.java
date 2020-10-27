package leetcode.middle.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution0809 {
    public List<String> generateParenthesis(int n) {
        if (n <= 0)
            return new LinkedList<String>();
        List<String> res = new ArrayList<String>();
        String s = "";
        back(2*n,n, s, res,0,0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0809().generateParenthesis(3));
    }

    public void back(int length,int n, String s, List<String> res,int left,int right) {
        if (s.length() == length){
            res.add(s);
            return;
        }

        if (left == right && n > 0) {
            back(length,n-1,s+"(",res,left+1,right);
        } else if (left > right && n > 0) {
            back(length,n-1,s+"(",res,left+1,right);
            back(length,n,s+")",res,left,right+1);
        } else {
            back(length,n,s+")",res,left,right+1);
        }
    }
}
