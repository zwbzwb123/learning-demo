package leetcode.middle.sort;

import com.sun.scenario.effect.Merge;
import com.sun.scenario.effect.Offset;

import java.util.List;

public class Solution148 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode quick = head;
        while (quick!= null && quick.next!= null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode listOne = sortList(head);
        ListNode listTwo = sortList(next);
        ListNode res = new ListNode(0);
        ListNode h = res;
        while (listOne != null && listTwo != null) {
            if (listOne.val <= listTwo.val) {
                h.next = listOne;
                listOne = listOne.next;
            } else {
                h.next = listTwo;
                listTwo = listTwo.next;
            }
            h = h.next;
        }
        h.next = listOne == null ? listTwo : listOne;
        return res.next;
        //  return merge(listOne,listTwo);
    }

    private ListNode merge(ListNode listOne, ListNode listTwo) {
        if (listOne == null)
            return listTwo;
        if (listTwo == null)
            return listOne;
        if (listOne.val <= listTwo.val) {
            listOne.next = merge(listOne.next, listTwo);
            return listOne;
        } else {
            listTwo.next = merge(listOne, listTwo.next);
            return listTwo;
        }
    }
}
