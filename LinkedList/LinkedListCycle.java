package Ningbo.LinkedList;

import Ningbo.Util.ListNode;

/**
 * Created by zhang on 7/8/16.
 * slow - quick 指针, 还是使用快指针的技巧, quick != null && quick.next != null
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return head.next == head;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                return true;
            }
        }
        return false;
    }
}
