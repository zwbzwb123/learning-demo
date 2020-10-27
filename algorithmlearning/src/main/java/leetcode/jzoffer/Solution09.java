package leetcode.jzoffer;

import java.util.LinkedList;

public class Solution09 {
    class CQueue {

        LinkedList<Integer> stack1;
        LinkedList<Integer> stack2;
        public CQueue() {
            stack1 = new LinkedList<Integer>();
            stack2 = new LinkedList<Integer>();
        }

        public void appendTail(int value) {
            stack1.addLast(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    Integer i = stack1.removeLast();
                    stack2.addLast(i);
                }
            }
            if (stack2.isEmpty())
                return -1;
            else
                return stack2.removeLast();
        }
    }
}
