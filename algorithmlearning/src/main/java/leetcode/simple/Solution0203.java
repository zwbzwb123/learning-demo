package leetcode.simple;

public class Solution0203 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public static void main(String[] args) {
        Solution0203 solution0203 = new Solution0203();
        ListNode n1 = solution0203.new ListNode(4);
        ListNode n2 = solution0203.new ListNode(5);
        n1.next = n2;
        ListNode n3 = solution0203.new ListNode(1);
        n2.next = n3;
        ListNode n4 = solution0203.new ListNode(9);
        n3.next = n4;

        solution0203.deleteNode(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
}
