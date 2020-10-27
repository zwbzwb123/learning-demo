package leetcode.middle.tree;


public class Solution1302 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int maxLevel = 1;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;
        dfs(1, root, 0);
        return sum / 2;
    }

    public void dfs(int level, TreeNode root, int count) {
        if (root == null) {
            if (level > maxLevel) {
                maxLevel = level;
                sum = count;
            } else if (level == maxLevel) {
                sum += count;
            }
            return;
        }

        dfs(level + 1, root.left, root.val);
        dfs(level + 1, root.right, root.val);
    }
}
