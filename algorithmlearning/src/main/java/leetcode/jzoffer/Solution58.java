package leetcode.jzoffer;

public class Solution58 {
    public String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0,n);
        String s2 = s.substring(n, s.length());
        return s2+s1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution58().reverseLeftWords("abcdefg",2));
    }
}
