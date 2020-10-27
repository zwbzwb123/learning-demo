package leetcode.simple;

public class Solution1108 {

    public String defangIPaddr(String address) {
        if (address.isEmpty()) return null;

        StringBuilder sb = new StringBuilder();
        int length = address.length();
        for (int i = 0; i < length; i++) {
            char c = address.charAt(i);
            if (c == '.')  sb.append("[.]");
            else sb.append(c);
        }

        return sb.toString();
    }
}
