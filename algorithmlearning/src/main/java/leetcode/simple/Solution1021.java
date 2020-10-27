package leetcode.simple;

import java.util.LinkedList;

public class Solution1021 {
    public static void main(String[] args) {
        System.out.println(new Solution1021().removeOuterParentheses("(()())(())(()(()))"));
    }
    public String removeOuterParentheses(String S) {
        if (S.length() <= 0)
            return "";
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (Character c: S.toCharArray()){
            if (c == '(' && count++ > 0)
                sb.append(c);
            if (c == ')' && --count > 0)
                sb.append(c);
        }
        return sb.toString();
    }
}
