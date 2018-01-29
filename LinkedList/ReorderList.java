package Ningbo.LinkedList;

import Ningbo.Util.ListNode;

/**
 * Created by zhang on 7/6/16.
 * 用了自己的笨办法: 刚开始获取最后一个点,copy一份,做相关链接,但无法将最后一个点置空
 *                  后来获取最后倒数第二个点,倒数一个点用lastSecond.next表示,并将lastSecond.next = null
 *                  办法比较笨,需要参考答案优化
 *
 */
public class ReorderList {
    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode midNode = midNode(head);
        while (head != midNode) {
            ListNode lastSecond = lastSecondNode(head);
            ListNode newLast = new ListNode(lastSecond.next.val);
            lastSecond.next = null;
            newLast.next = head.next;
            head.next = newLast;
            head = newLast.next;
        }
        return dummy.next;
    }

//    private ListNode lastNode(ListNode head) {
//        ListNode quick1 = head;
//        ListNode quick2 = head.next;
//        while (quick2 != null && quick2.next != null) {
//            quick1 = quick1.next.next;
//            quick2 = quick2.next.next;
//        }
//        return quick2 != null ? quick2 : quick1;
//    }
    private ListNode lastSecondNode(ListNode head) {
        ListNode quick0 = new ListNode(0);
        quick0.next = head;
        ListNode quick1 = head;
        ListNode quick2 = head.next;
        while (quick2 != null && quick2.next != null) {
            quick0 = quick0.next.next;
            quick1 = quick1.next.next;
            quick2 = quick2.next.next;
        }
        if (quick2 != null) {
            return quick1;
        }
        else {
            return quick0;
        }
    }

    private ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head.next;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
}
