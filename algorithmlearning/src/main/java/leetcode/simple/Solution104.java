package leetcode.simple;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution104 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        // 递归
         return compute(root,0);

        // 迭代
//        if (root == null)
//            return 0;
//        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
//        stack.offer(root);
//        int depth = 0;
//        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
//        map.put(root, 1);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.poll();
//            Integer dep = map.get(node);
//            if (dep > depth)
//                depth = dep;
//            if (node.left != null) {
//                map.put(node.left, dep + 1);
//                stack.offer(node.left);
//            }
//            if (node.right != null) {
//                map.put(node.right, dep + 1);
//                stack.offer(node.right);
//            }
//        }
//        return depth;
    }

    public int compute(TreeNode root, int count) {
        if (root == null)
            return count;
        return Math.max(
                compute(root.left, count + 1),
                compute(root.right, count + 1)
        );
    }
}
