package Ningbo.LinkedList;

import Ningbo.Util.ListNode;

import java.util.List;

/**
 * Created by zhang on 7/7/16.
 *
 * Merge sort:
 *      错误点: while (l1 != null && l2 != null) 其实也对应了上面的退出点l1 == null && l2 == null
 *      注意点: 1. head == null || head.next == null
 *             2. l1 == null && l2 == null
 *             3. right = slow.next; slow.next = null; 断开slow,形成两个list
 *
 * Quick sort:
 *      注意点: 一次找出三条List后,结尾分别要置空,
 *             head = head.next 即不进行pivot与pivot的比较
 *      错误点: 1. 如果左list为空, left = dummyPivot.next
 *             2. currentLeft.next = dummyPivot.next 错误, 而应该将left遍历到最后,用最后的结点链接dummyPivot.next???
 */
public class SortList {
    //Solution 1 : merge sort
    public ListNode mergeSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode quick = head.next;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

//        ListNode l2 = slow.next;
        ListNode right = slow.next;
        slow.next = null;

        ListNode l1 = mergeSortList(head);
        ListNode l2 = mergeSortList(right);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
//        while (current != null) {
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }
        return dummy.next;
    }

    //Solution 2: quick sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pivot = head;
        head = head.next;
        ListNode dummyPivot = new ListNode(0);
        dummyPivot.next = pivot;

        ListNode dummyLeft = new ListNode(0);
        ListNode currentLeft = dummyLeft;
        ListNode dummyRight = new ListNode(0);
        ListNode currentRight = dummyRight;

//        while (head.next != null) {
        //上面用head = head.next来解决这里head.next != null的错误
        while (head != null) {
            if (head.val < pivot.val) {
                currentLeft.next = head;
                currentLeft = currentLeft.next;
            }
            else if (head.val > pivot.val) {
                currentRight.next = head;
                currentRight = currentRight.next;
            }
            else {
                pivot.next = head;
                pivot = pivot.next;
            }
            head = head.next;
        }

        //形成3条list
        currentLeft.next = null;
        currentRight.next = null;
        pivot.next = null;

        ListNode left = sortList(dummyLeft.next);
        if (left == null) {
            left = dummyPivot.next;
        }
        else {
//            left.next = dummyPivot.next;
//            currentLeft.next = dummyPivot.next;
//            while (left.next != null) {
//                left = left.next;
//            }
//            left.next = dummyPivot.next;
            ListNode current = left;
            while (current.next != null) {
                current = current.next;
            }
            current.next = dummyPivot.next;
        }
        ListNode right = sortList(dummyRight.next);
        pivot.next = right;
        return left;
    }
}
