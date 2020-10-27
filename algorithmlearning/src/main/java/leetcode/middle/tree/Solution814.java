package leetcode.middle.tree;

public class Solution814 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        if (!prune(root, root.left))
            root.left = null;

        if (!prune(root, root.right))
            root.right = null;
        return root;
    }

    private boolean prune(TreeNode parent, TreeNode c) {
        if (c == null)
            return false;
        if (!prune(c, c.left))
            c.left = null;
        if (!prune(c, c.right))
            c.right = null;
        if (c.val == 1) {
            return true;
        }
        return c.left != null || c.right != null;
    }
}
// 1
//  0
// 0 1
