package leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution1288 {
    public static void main(String[] args) {
        System.out.println(new Solution1288().removeCoveredIntervals(new int[][]{
                {1,4},
                {1,2},
                {3,4}
        }));
    }
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1]:o1[0] - o2[0];
            }
        });

        int count = 0;
        int pre = 0;
        for (int[] a:intervals) {
            if (a[1] > pre){
                count++;
                pre = a[1];
            }
        }
        return count;
    }
}
