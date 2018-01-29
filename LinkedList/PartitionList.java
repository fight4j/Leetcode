package Ningbo.LinkedList;

import Ningbo.Util.ListNode;

/**
 * Created by zhang on 7/4/16.
 *
 * 错误点:left,right只是重复了head的动作,无意义
 *       用dummy点时,head作为前哨, 1.dummy.next = head; 2.dummy = head; 3.head前移
 *       最后left, right都保证不为空,省去了判断空的很多操作,简化许多
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLeft = new ListNode(0);
        ListNode dummyRight = new ListNode(0);
//        ListNode left = null;
//        ListNode right = null;
        ListNode left = dummyLeft;
        ListNode right = dummyRight;

        boolean isDummyLeftLinked = false;
        boolean isDummyRightLinked = false;

        while (head != null) {
            if (head.val < x) {
                if (!isDummyLeftLinked) {
                    dummyLeft.next = head;
                    isDummyLeftLinked = true;
                }
                left.next = head;
                left = head;
//                left = head;
//                head = head.next;
//                left.next = head;
            }
            else {
                if (!isDummyRightLinked) {
                    dummyRight.next = head;
                    isDummyRightLinked = true;
                }
                right.next = head;
                right = head;
//                right = head;
//                head = head.next;
//                right.next = head;
            }
            head = head.next;
        }

//        if (left == null && right == null) {
//            return null;
//        }
//        else if (left == null) {
//            return dummyRight.next;
//        }
//        else if (right == null) {
//            return dummyLeft.next;
//        }
//        else {
            left.next = dummyRight.next;
            right.next = null;
            return dummyLeft.next;
//        }
    }
}
