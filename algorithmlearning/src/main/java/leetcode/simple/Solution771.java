package leetcode.simple;

import java.util.HashMap;
import java.util.Map;

public class Solution771 {

    public int numJewelsInStones(String J, String S) {

        int res = 0;
        HashMap<Character,Integer> map =  new HashMap<>();

        for (Character c : S.toCharArray())
            map.merge(c, 1, (a, b) -> a + b);

        Integer t;
        for (Character c: J.toCharArray()) {
            t = map.get(c);
            if (t == null)
                continue;
            res += t;
        }
        return res;
    }
}
