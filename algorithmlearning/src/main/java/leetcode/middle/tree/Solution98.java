package leetcode.middle.tree;

public class Solution98 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null,null);
    }


    public boolean dfs(TreeNode root, Integer low,Integer height) {
        if (root == null)
            return true;

        if ( (low != null) && root.val <= low) return false;
        if ( (height != null) && root.val >= height) return false;

        return dfs(root.left,low,root.val) && dfs(root.right,root.val,height);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        root.left = node1;
        TreeNode node2 = new TreeNode(5);
        root.right = node2;
        TreeNode node3 = new TreeNode(0);
        node1.left = node3;
        TreeNode node4 = new TreeNode(2);
        node1.right = node4;
        TreeNode node5 = new TreeNode(4);
        node2.left = node5;
        TreeNode node6 = new TreeNode(3);
        node2.left = node6;

        System.out.println(new Solution98().isValidBST(root));
    }
}
