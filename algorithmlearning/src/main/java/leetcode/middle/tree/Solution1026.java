package leetcode.middle.tree;


public class Solution1026 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

 //   LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    int max = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        preOrder(root,root.val,root.val);
        return max;
    }

    private void preOrder(TreeNode root,int height,int lower) {
        if (root == null)
            return;
//        for (TreeNode node : stack) {
//            int a;
//            if ((a = Math.abs(root.val - node.val)) > max)
//                max = a;
//        }
//        stack.addLast(root);
        if (root.val < lower)
            lower = root.val;
        else if (root.val > height)
            height  = root.val;
        int x  = Math.abs(height-lower);
        if (x > max)
            max = x;
        preOrder(root.left,height,lower);
        preOrder(root.right,height,lower);
//        stack.removeLast();
    }
}
