package leetcode.simple;

import sun.invoke.util.BytecodeName;

import java.util.Arrays;

public class Solution0402 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0)
            return null;
        return insert(0,nums.length,nums);
    }

    public TreeNode insert(int left,int right,int[] nums){
        if (right < left)
            return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = insert(left,mid-1,nums);
        root.right = insert(mid+1,right,nums);
        return root;
    }
}
