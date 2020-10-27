package leetcode.simple;

import sun.plugin.javascript.navig.Link;

import java.util.LinkedList;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class Solution155 {
    class MinStack {

        LinkedList<Integer> stack;
        LinkedList<Integer> min  = new LinkedList<Integer>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<Integer>();
        }

        public void push(int x) {
            stack.addLast(x);
            if (min.isEmpty() || x <= min.getLast())
                min.addLast(x);
        }

        public void pop() {
            Integer x = stack.removeLast();
            if (min.getLast() .equals(x))
                min.removeLast();
        }

        public int top() {
            return stack.getLast();
        }

        public int getMin() {
            return min.getLast();
        }
    }
}
