package leetcode.middle.tree;

public class Solution1379 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return findNode(cloned, target);
    }

    private TreeNode findNode(TreeNode root, TreeNode target) {
        if (root.val == target.val)
            return root;
        if (root.left != null) {
            TreeNode node = findNode(root.left, target);
            if (node != null)
                return node;
        }
        if (root.right != null) {
            TreeNode node = findNode(root.right, target);
            if (node != null)
                return node;
        }
        return null;
    }
}
