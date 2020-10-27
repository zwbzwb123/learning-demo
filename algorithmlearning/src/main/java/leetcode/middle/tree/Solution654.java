package leetcode.middle.tree;

public class Solution654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int index = findMax(nums, left, right);
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums, left, index - 1);
        root.right = build(nums, index + 1, right);
        return root;
    }

    public int findMax(int[] nums, int left, int right) {
        int index = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        new Solution654().build(new int[]{3, 2, 1, 6, 0, 5}, 0, 5);
    }

}
