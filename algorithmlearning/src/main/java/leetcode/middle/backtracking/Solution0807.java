package leetcode.middle.backtracking;

import java.util.*;

public class Solution0807 {

    public String[] permutation(String S) {
        List<String> res = new ArrayList<String>();
//        boolean[] used = new boolean[S.length()];
//        backtrace(S.toCharArray(), res,"",used);
        dfs(0,S.toCharArray(),res);
        return res.toArray(new String[0]);
    }

    private void backtrace(char[] chars, List<String> res, String sb,boolean[] used) {
        if (sb.length() == chars.length) {
            res.add(sb);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!used[i]){
                used[i] = true;
                backtrace(chars,res,sb+chars[i],used);
                used[i] = false;
            }
        }
    }

    private void dfs(int x,char[] chars,List<String> res){
        if (x == chars.length-1){
            res.add(new String(chars));
            return;
        }

        for (int i = x; i < chars.length; i++) {
            swap(x,i,chars);
            dfs(x+1,chars,res);
            swap(i,x,chars);
        }
    }

    private void swap(int i, int x,char[] chars) {
        char t = chars[i];
        chars[i] = chars[x];
        chars[x] = t;
    }

    public static void main(String[] args) {

        String[] abcs = new Solution0807().permutation("abc");
        for (String s:abcs){
            System.out.println(s);
        }
    }
}
