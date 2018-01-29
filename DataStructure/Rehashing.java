package Ningbo.DataStructure;

import Ningbo.Util.ListNode;

/**
 * Created by zhang on 7/16/16.
 *
 * 思路 : 笨办法 循环遍历
 *
 * 错误点: 低级错误,找List的最后一个点
 */
public class Rehashing {
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return null;
        }

        int size = 2 * hashTable.length;
        ListNode[] newHashTable = new ListNode[size];
        for (ListNode node : hashTable) {
            while (node != null) {
                int val = node.val;
                int position = (val % size + size) % size;
                ListNode newNode = new ListNode(val);
                if (newHashTable[position] == null) {
                    newHashTable[position] = newNode;
                }
                else {
                    ListNode head = newHashTable[position];
//                    while (head != null) {
                    while (head.next != null) {
                        head = head.next;
                    }
                    head.next = newNode;
                }
                node = node.next;
            }
        }
        return newHashTable;
    }
}
