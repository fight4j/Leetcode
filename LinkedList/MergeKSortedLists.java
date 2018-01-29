package Ningbo.LinkedList;

import Ningbo.Util.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zhang on 7/6/16.
 * 思路:
 *      1.heads = clearHeads(lists, heads); 清理一遍所有的头节点,去除null
 *      2.循环遍历头节点,小者出列
 *      3.heads = updateHeads(heads, minNodeInList); heads中更新刚才出列的头节点
 *
 * 错误点:1.minNodeInList应写在while里,每次小者出列后要重置
 */
public class MergeKSortedLists {

    /**
     * Version 1 : 自己的笨办法
     *
     */

    public ListNode mergeKLists(List<ListNode> lists) {
        ArrayList<ListNode> heads = new ArrayList<ListNode>();

        ListNode dummy = new ListNode(0);
        ListNode currentResult = dummy;
//        ListNode minNodeInList = new ListNode(Integer.MAX_VALUE);

        heads = clearHeads(lists, heads);
        while (!heads.isEmpty()) {
            ListNode minNodeInList = new ListNode(Integer.MAX_VALUE);
//            for (ListNode head : lists) {
            for (ListNode head : heads) {
                if (head.val < minNodeInList.val) {
                    minNodeInList = head;
//                    head = head.next;
//                    currentResult.next = minNodeInList;
//                    currentResult = currentResult.next;
                }
            }
            currentResult.next = minNodeInList;
            currentResult = currentResult.next;
            heads = updateHeads(heads, minNodeInList);
        }
        return dummy.next;
    }

    private ArrayList<ListNode> clearHeads(List<ListNode> lists, ArrayList<ListNode> heads) {
        heads.clear();
        for (ListNode head : lists) {
            if (head != null) {
                heads.add(head);
            }
        }
        return heads;
    }

    private ArrayList<ListNode> updateHeads(ArrayList<ListNode> heads, ListNode oldNode) {
        if (heads.contains(oldNode)) {
            heads.remove(oldNode);
            if (oldNode.next != null) {
                heads.add(oldNode.next);
            }
        }
        return heads;
    }

    /**
     * Version 2 : PriorityQueue
     *
     */
    public ListNode mergeKListsMethodII(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        Comparator<ListNode> nodeComparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        PriorityQueue<ListNode> nodePriorityQueue = new PriorityQueue<ListNode>(lists.size(), nodeComparator);
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                nodePriorityQueue.add(node);
            }
        }
        while (!nodePriorityQueue.isEmpty()) {
            ListNode node = nodePriorityQueue.poll();
            if (node.next != null) {
                nodePriorityQueue.add(node.next);
            }
            current.next = node;
            current = current.next;
        }
        return dummy.next;
    }
}
