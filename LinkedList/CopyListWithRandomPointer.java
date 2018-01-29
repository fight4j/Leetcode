package Ningbo.LinkedList;

import Ningbo.Util.RandomListNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zhang on 7/5/16.
 * 不要用什么prev, newHead之类然后再加判断,用一个dummy和current, current链接到下一个后就后移
 *
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
//        RandomListNode prev = null;
//        RandomListNode newHead = null;
//
//        while (head != null) {
//            RandomListNode rNode = new RandomListNode(head.label);
//            if (prev == null) {
//                prev = head;
//                newHead = head;
//            }
//            else {
//                prev.next = rNode;
//                prev = prev.next;
//            }
//        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode current = dummy;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            current.next = newNode;

            newNode.random = head.random;
            map.put(head, newNode);

            head = head.next;
            current = current.next;
        }

        current = dummy.next;
        while (current != null) {
            if (current.random != null) {
                current.random = map.get(current.random);
            }
            current = current.next;
        }
        return dummy.next;
    }
}
