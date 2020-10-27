package leetcode.middle.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.SortedSet;

public class Solution1381 {

    class CustomStack {

        LinkedList<Integer> stack;
        int size;
        int count;
        int[] incr;

        public CustomStack(int maxSize) {
            stack = new LinkedList<Integer>();
            size = maxSize;
            count = 0;
            incr = new int[maxSize + 1];
        }

        public void push(int x) {
            if (count == size)
                return;
            count++;
            stack.addLast(x);
        }

        public int pop() {
            if (count == 0)
                return -1;
            Integer i = stack.removeLast();
            if (incr[count] > 0) {
                i += incr[count];

                incr[count - 1] += incr[count];
                incr[count] = 0;
            }
            count--;
            return i;
        }

        public void increment(int k, int val) {
            if (k > count) {
                incr[count] += val;
            } else {
                incr[k] += val;
            }
        }
    }
}
