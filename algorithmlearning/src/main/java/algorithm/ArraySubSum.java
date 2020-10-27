package algorithm;

public class ArraySubSum {

    /*
      从给定的一个数组中，找到值相加最大的一段序列，并返回总和，最小为0
      此方法计算的时间复杂度为 O(NLogN)
    */
    public int maxSumRec(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }

        int center = (right + left) / 2;
        int leftMaxSum = maxSumRec(a, left, center);
        int rightMaxSum = maxSumRec(a, center + 1, right);

        int leftSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftSum += a[i];
            if (leftSum > leftBorderSum)
                leftBorderSum = leftSum;
        }

        int rightSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightSum += a[i];
            if (rightSum > rightBorderSum)
                rightBorderSum = rightSum;
        }

        int centerMaxSum = rightBorderSum + leftBorderSum;

        if (leftMaxSum > rightMaxSum)
            rightMaxSum = leftMaxSum;
        if (rightMaxSum > centerMaxSum)
            centerMaxSum = rightMaxSum;
        return centerMaxSum;
    }

    /*
        第一、负数不可以作为序列的起点
        第二、如果序列起点为i 终点为p,sum<0 那么[i,p]范围内的一定不会成为起点
     */
    public int maxSumRec(int[] a) {
        int thisSum = 0, maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }
        return maxSum;
    }

    /*
        求最小正子序列和
        可以以负数开头，但是最终结果需要为正数
     */
    public int minSumRec(int[] a, int left, int right) {
        if (left == right)
            return a[left];

        int center = (right + left) / 2;
        int minLeftSum = minSumRec(a, left, center);
        int minRightSum = minSumRec(a, center + 1, right);

        int leftBorderSum = Integer.MAX_VALUE, leftSum = 0;
        for (int i = center; i >= left; i--) {
            leftSum += a[i];
            if (leftSum > 0 && leftSum < leftBorderSum)
                leftBorderSum = leftSum;
        }

        int rightBorderSum = Integer.MAX_VALUE, rightSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightSum += a[i];
            if (rightSum > 0 && rightSum < rightBorderSum)
                rightBorderSum = rightSum;
        }

       int minCenterSum = Math.min(leftBorderSum,rightBorderSum);

        if (minLeftSum < 0)
            minLeftSum = minCenterSum;
        if (minRightSum < 0)
            minRightSum = minCenterSum;

        int min = Math.min(minLeftSum, minCenterSum);
        return Math.min(
                min,
                minRightSum
        );
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,-1,2,2,-3};
        System.out.println(new ArraySubSum().minSumRec(a, 0, a.length - 1));
    }
}
