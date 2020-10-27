package leetcode.simple;

import java.util.LinkedList;

public class Solution226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            if (node.left != null)
                stack.offer(node.left);
            if (node.right != null)
                stack.offer(node.right);

            TreeNode t = node.left;
            node.left = node.right;
            node.right = t;
        }
        return root;

//        递归
//        if (root == null)
//            return null;
//
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//
//        root.left = right;
//        root.right = left;
//
//        invertTree(left);
//        invertTree(right);
//
//        return root;
    }


}
