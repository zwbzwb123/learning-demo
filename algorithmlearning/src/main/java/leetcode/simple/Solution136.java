package leetcode.simple;

import java.util.Arrays;

public class Solution136 {

    //给定一个非空整数数组，除了某个元素只出现一次以外，
    //其余每个元素均出现两次。找出那个只出现了一次的元素。
    //你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i;
        for (i = 0; i < nums.length; i += 2) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1])
                break;
        }
        return nums[i];

        // 相同的数异或为0
        //int single = 0;
        //        for (int num : nums) {
        //            single ^= num;
        //        }
        //        return single;
        //
        //作者：LeetCode-Solution
        //链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
