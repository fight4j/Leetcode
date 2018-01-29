package Ningbo.LinkedList;

import Ningbo.Util.ListNode;

/**
 * Created by zhang on 7/7/16.
 *
 * 在reverse linked list 的基础上,将反转前的头一个点链接到prev(反转后新的头),反转后的tail链接到next(翻转链表的后一个点)
 * 错误点 : 1.反转中head后移逻辑为head = next 不能与下面代码head = head.next合并
 *         2.不是prev = prev.next
 *         3.反转核心逻辑要更加熟练 next = head.next head.next = prev prev = head head = next
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m < 1 || n < 1 || m > n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int index = 1;

        //反转list头节点的前向节点,即m - 1 若index == m - 1未进入则此处已初始化好
        ListNode prevNodeOfReversedListHead = dummy;
        //反转List反转前的头节点
        ListNode reversedListHead = dummy.next;
        //反转List循环时的prev 和 next
        ListNode prev = null;
        ListNode next = null;

        while (index <= n) {
            if (index == m - 1) {
                prevNodeOfReversedListHead = head;
                reversedListHead = prevNodeOfReversedListHead.next;
            }
            if (index >= m && index <= n) {
                next = head.next;
                head.next = prev;

                //错误点
//                prev = prev.next;
                prev = head;
                head = next;
                index++;
                continue;
            }
            head = head.next;
            index++;
        }
        prevNodeOfReversedListHead.next = prev;
        reversedListHead.next = next;
        return dummy.next;
    }
}
