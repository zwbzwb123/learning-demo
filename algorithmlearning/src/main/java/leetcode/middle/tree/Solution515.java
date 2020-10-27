package leetcode.middle.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution515 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, 0);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        Integer i = map.get(level);
        if (i == null || root.val > i)
            map.put(level, root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
