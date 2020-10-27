package leetcode.middle.sort;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1305 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Heap heap = new Heap();
        add(root1, heap);
        add(root2, heap);
        List<Integer> res = new ArrayList<Integer>();
        while (!heap.isEmpty()) {
            res.add(heap.deleteMin());
        }
        return res;
    }

    public void add(TreeNode root, Heap heap) {
        if (root == null)
            return;
        heap.insert(root.val);
        if (root.left != null)
            add(root.left, heap);
        if (root.right != null)
            add(root.right, heap);
    }

    class Heap {
        int[] a = new int[10001];
        int size = 0;

        public boolean isEmpty() {
            return size == 0;
        }

        public void insert(int data) {
            a[0] = data;
            int hole = ++size;
            while (data < a[hole / 2] && hole > 0) {
                a[hole] = a[hole / 2];
                hole = hole / 2;
            }
            a[hole] = data;
        }

        public int deleteMin() {
            int min = a[1];
            a[1] = a[size--];
            percolate(1);
            return min;
        }

        private void percolate(int i) {
            int child;
            int hole = i;
            int temp = a[i];
            for (; hole * 2 <= size; hole = child) {
                child = hole * 2;
                if (child != size && a[child] > a[child + 1])
                    child++;
                if (a[child] < temp)
                    a[hole] = a[child];
                else break;
            }
            a[hole] = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(-10);
        TreeNode node3 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(0);
        TreeNode node8 = new TreeNode(2);

        node4.left = node5;
        node4.right= node6;

        node5.left = node7;
        node5.right = node8;

        System.out.println(new Solution1305().getAllElements(node1,node4));
    }
}
