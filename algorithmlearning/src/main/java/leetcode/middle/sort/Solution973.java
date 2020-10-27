package leetcode.middle.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution973 {

    class cmp implements Comparator<Integer[]> {

        public int compare(Integer[] o1, Integer[] o2) {
            return compute(o1[0],o1[2]) - compute(o2[0],o2[1]);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(new cmp());
        for (int i = 0; i < points.length; i++) {
            queue.offer(new Integer[]{points[i][0],points[i][1]});
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            Integer[] poll = queue.poll();
            res[i][0] = poll[0];
            res[i][1] = poll[1];

        }
        return res;
    }

    public int compute(int a, int b) {
        return a * a + b * b;
    }
}
