package leetcode.middle.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution145 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) return res;

        return null;
    }


    public void iterate(TreeNode node){
        if (node == null)
            return;
        if (node.left != null)
            iterate(node.left);
        if (node.right != null)
            iterate(node.right);
        res.add(node.val);
    }

}
