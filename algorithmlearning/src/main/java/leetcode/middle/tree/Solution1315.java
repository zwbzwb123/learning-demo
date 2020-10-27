package leetcode.middle.tree;

public class Solution1315 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(null, null, root);
        return sum;
    }

    public void dfs(TreeNode gp, TreeNode p, TreeNode c) {
        if (c == null)
            return;
        if (gp != null && (gp.val & 1) == 0)
            sum += c.val;
        dfs(p,c,c.left);
        dfs(p,c,c.right);
    }


}
