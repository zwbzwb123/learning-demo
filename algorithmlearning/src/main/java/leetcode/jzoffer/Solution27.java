package leetcode.jzoffer;

import javax.xml.soap.Node;

public class Solution27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        mirror(root);
        return root;
    }

    public void mirror(TreeNode root){
        if (root == null)
            return;
        if (root.left != null && root.right != null){
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
        } else if (root.left == null) {
            root.left = root.right;
            root.right = null;
        } else if (root.right == null ) {
            root.right = root.left;
            root.left = null;
        }

        mirror(root.left);
        mirror(root.right);
    }
}
