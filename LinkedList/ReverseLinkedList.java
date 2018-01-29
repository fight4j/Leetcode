package Ningbo.LinkedList;

import Ningbo.Util.ListNode;

/**
 * Created by zhang on 7/3/16.
 *
 * head保存当前值, next保存head源list的next, prev保存前一head
 * Step: 1.next后移
 *       2.head.next指向prev
 *       3.prev后移
 *       4.head后移
 * 错误点: head最终指向null,所以新链表的头结点为prev,即返回prev
 */
public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
//        if (head == null) {
//            return null;
//        }

        ListNode next = null;
        ListNode prev = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
//        return head;
        return prev;
    }
}
