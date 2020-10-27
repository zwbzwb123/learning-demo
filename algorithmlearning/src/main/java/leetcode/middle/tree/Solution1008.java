package leetcode.middle.tree;

public class Solution1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null)
            return null;
        this.preorder = preorder;
        this.n = preorder.length;
        return buildTree(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int index = 0;
    int[] preorder;
    int n;

    public TreeNode buildTree(int low, int upper) {
        if (index >= n)
            return null;
        if (preorder[index] < low || preorder[index] > upper)
            return null;
        TreeNode cur = new TreeNode(preorder[index++]);
        cur.left = buildTree(low,cur.val);
        cur.right = buildTree(cur.val,upper);
        return cur;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
