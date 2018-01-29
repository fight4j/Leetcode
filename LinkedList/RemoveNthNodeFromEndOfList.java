package Ningbo.LinkedList;

import Ningbo.Util.ListNode;

import java.util.List;

/**
 * Created by zhang on 7/3/16.
 *
 * challenge: do it without getting the length of the linked list
 * 所以想到先reverse,去掉目标结点后,再reverse返回
 * 方法    1. n == 1时,即移除第一个结点时,要特殊处理,不能加dummynode统一处理,因为后面还要继续翻转
 *        2. n >= 1时,用targetPrev处理
 *         但其实这个方法过于复杂, 还没有length来的方便
 *
 * update1: dummynode 统一处理也可以,最后reverse(dummy.next)
 *
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0 || head == null) {
            return null;
        }

        head = reverse(head);
//        if (n == 1) {
//            return reverse(head.next);
//        }

        ListNode dummy = new ListNode(0);
        ListNode target = head;
        ListNode targetPrev = dummy;

        int index = 1;
        while (index != n) {
            targetPrev = target;
            target = target.next;
            index++;
        }
        targetPrev.next = target.next;
        target.next = null;

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode next = null;
        ListNode prev = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
