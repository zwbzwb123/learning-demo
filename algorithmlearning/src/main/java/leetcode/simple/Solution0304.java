package leetcode.simple;

import java.util.LinkedList;

public class Solution0304 {
    class MyQueue {

        LinkedList<Integer> stackOne;
        LinkedList<Integer> stackTwo;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stackOne = new LinkedList<Integer>();
            stackTwo = new LinkedList<Integer>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stackOne.addLast(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (stackTwo.isEmpty()){
                while (!stackOne.isEmpty())
                    stackTwo.addLast(stackOne.removeLast());
            }
            return stackTwo.removeLast();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            int v = pop();
            stackTwo.addLast(v);
            return v;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stackTwo.isEmpty() && stackOne.isEmpty();
        }
    }
}
