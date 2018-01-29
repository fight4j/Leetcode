package Ningbo.LinkedList;

import Ningbo.Util.ListNode;
import Ningbo.Util.TreeNode;

/**
 * Created by zhang on 7/5/16.
 *
 * balanced bst --> 取1/2 length点, 前面的放左子树,后面的放右子树,递归
 * 错误点: 1. 用pointer去循环遍历获取Length,而不是head
 *        2. while (currentIndex < rootIndex) 确保currentIndex走到rootIndex保持一致,
 *        3. 计算左右子数时,rootIndex为左边链表个数,右边则为length - rootIndex - 1(root本身)
 */
public class ConvertSortedListToBalancedBST {
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode pointer = head;
//        while (head != null) {
//            length++;
//            head = head.next;
//        }
        while (pointer != null) {
            length++;
            pointer = pointer.next;
        }

        return bstHelper(head, length);
    }

    private TreeNode bstHelper(ListNode head, int length) {
        if (length <= 0) {
            return null;
        }

        int rootIndex = (length - 1) / 2;    //对比binary search 的 mid = start + (end - start) / 2
        int currentIndex = 0;
        ListNode currentNode = head;
//        while (currentIndex <= rootIndex) {
        while (currentIndex < rootIndex) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        TreeNode root = new TreeNode(currentNode.val);
//        root.left = bstHelper(head, length - currentIndex - 1);
        root.left = bstHelper(head, rootIndex);
        root.right = bstHelper(currentNode.next, length - rootIndex - 1);
        return root;
    }
}
