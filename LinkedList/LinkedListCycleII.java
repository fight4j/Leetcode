package Ningbo.LinkedList;

import Ningbo.Util.ListNode;

/**
 * Created by zhang on 7/8/16.
 * 思路 : 沿用linked list cycle的思路,快慢指针
 *         结论为当快慢指针相遇后,慢指针向后,快指针重新指向头节点
 *         再次相遇时为cycle 的头节点
 *
 *         假设head 到 换开始的点的距离l1 ,环开始到第一次快慢指针相遇的地方距离l2,
 *         相遇点到环开始的地方距离l3
 *         因为第一次相遇时, 快指针比慢指针多跑一个环, 有
 *         2 (l1 + l2) + 1 = l1 + 2l2 + l3 --->  l1 + 1 = l3;  ---->(+1是因为快指针天生就走快了一步,后面大家是2倍关系)
 *         慢指针继续往前走,快指针先一步到head,后面走一样的路即与慢指针相遇
 *
 * 错误: 1.typo错误, quick = quick.next.next
 *      2. 漏下了slow = slow.next 造成LTE
 *
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head.next == head ? head : null;
        }

        ListNode slow = head;
        ListNode quick = head.next;
        while (quick != null && quick.next != null) {
            slow = slow.next;
//            quick = quick.next;
            quick = quick.next.next;
            if (slow == quick) {
                quick = head;
                //漏下
                slow = slow.next;
                while (slow != quick) {
                    quick = quick.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
