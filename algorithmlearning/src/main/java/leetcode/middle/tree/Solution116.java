package leetcode.middle.tree;

import java.util.LinkedList;

public class Solution116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //   LinkedList<Node> stack = new LinkedList<Node>();

    public Node connect(Node root) {
//        if (root == null)
//            return null;
//        Node p = root;
//        Node sentinel = new Node(-1);
//        Node pre = sentinel;
//        stack.addLast(p);
//        while (!stack.isEmpty()) {
//            Node node = stack.removeFirst();
//            pre.next = node;
//            pre = pre.next;
//            if (stack.isEmpty()) {
//                pre = sentinel.next;
//                while (pre != null) {
//                    if (pre.left != null)
//                        stack.addLast(pre.left);
//                    if (pre.right != null)
//                        stack.addLast(pre.right);
//                    pre = pre.next;
//                }
//                pre = sentinel;
//            }
//        }
//        return root;
        if (root == null)
            return null;
        Node p = root;
        dfs(p,p.left,p.right);
        return root;
    }

    public void dfs(Node parent, Node left,Node right) {
        if (parent == null || left == null )
            return;
        left.next = right;
        dfs(left,left.left,left.right);
        dfs(left,left.right,right.left);
        dfs(right,right.left,right.right);
    }
}
