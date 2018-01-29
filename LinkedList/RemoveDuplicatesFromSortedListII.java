package Ningbo.LinkedList;

import Ningbo.Util.ListNode;

import java.util.List;

/**
 * Created by zhang on 7/4/16.
 * 移除重复元素,简单起见从至少2个元素的List考虑
 *
 *      dummy --> prevprev --> prev --> head
 * 例子: dummy --> prevprev -->  3   -->  3  --> 1 --> 4 --> 2
 *
 *
 * 若prev与head相同, 则head一直往下探走到不同的元素或空,
 * 若最后一个3后还有2个元素以上, 则prev 和 head同时向后
 * 若最后一个3后没有或只有一个元素, 则prevprev --> head并返回
 *
 * update1: 这种写法没使用到sorted list的特性...
 * update2: 有用到sorted,相同的元素是连续的,不然就不是这种删除了,参考remove duplicates from unsorted list
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode headPrev = head;
        head = head.next;
        ListNode prevPrev = new ListNode(0);
        prevPrev.next = headPrev;
        ListNode dummy = new ListNode(0);
        dummy.next = prevPrev;

        while (head != null) {
            //排除dummy与head相同的情况,第一次不作比较
//            if (isFirstCompare) {
//                isFirstCompare = false;
//                headPrev = head;
//                head = head.next;
//                continue;
//            }

            if (headPrev.val == head.val) {
                while (head != null && headPrev.val == head.val) {
                    head = head.next;
                }
                if (head == null || head.next == null) {
                    prevPrev.next = head;
                }
                else {
                    headPrev = head;
                    prevPrev.next = headPrev;
                    head = head.next;
                }
            }
            else {
                prevPrev = headPrev;
                headPrev = head;
                head = head.next;
            }
        }
        return dummy.next.next;
    }
}
