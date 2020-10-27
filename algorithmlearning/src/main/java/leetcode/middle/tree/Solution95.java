package leetcode.middle.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution95 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0)
            return new ArrayList<TreeNode>();
        return generate(1,n);
    }

    private List<TreeNode> generate(int i, int n) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (i > n){
            res.add(null);
            return res;
        }

        for (int j = i; j <= n; j++) {
            List<TreeNode> left = generate(i,j-1);
            List<TreeNode> right = generate(j+1,n);

            for (TreeNode l:left){
                for (TreeNode r:right){
                    TreeNode node = new TreeNode();
                    node.val = j;
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }

        }
        return res;
    }


}
