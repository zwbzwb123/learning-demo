package leetcode.middle.tree;

import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution0403 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    LinkedList<TreeNode> stackOne = new LinkedList<TreeNode>();
    LinkedList<TreeNode> stackTwo = new LinkedList<TreeNode>();

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null)
            return null;
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        stackOne.addLast(tree);
        while (!stackOne.isEmpty() || !stackTwo.isEmpty()){
            ListNode t = new ListNode(0);
            if (!stackOne.isEmpty()){
                transfer(stackOne,stackTwo,t);
            }else{
                transfer(stackTwo,stackOne,t);
            }
            list.add(t.next);
        }
       return  list.toArray(new ListNode[0]);
    }

    public void transfer(LinkedList<TreeNode> stackOne, LinkedList<TreeNode> stackTwo,ListNode t){
        ListNode h = t;
        while (!stackOne.isEmpty()){
            TreeNode treeNode = stackOne.removeFirst();
            h.next = new ListNode(treeNode.val);
            h = h.next;
            if (treeNode.left != null)
                stackTwo.addLast(treeNode.left);
            if (treeNode.right!=null)
                stackTwo.addLast(treeNode.right);
        }
    }
}
