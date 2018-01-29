package Ningbo.BinaryTreeAndDivideConquer;

import Ningbo.Util.TreeNode;

import java.util.Stack;

/**
 * Created by zhang on 6/26/16.
 * binary search tree inorder: stack中不断push进左节点
 * 并将current指针指向右节点
 *
 * 错误代码分析:误写成stack != null 则hasNext永远为true 导致next()报nullPointer
 */

public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack;
    private TreeNode current;
    public BinarySearchTreeIterator(TreeNode node) {
        stack = new Stack<TreeNode>();
        current = node;
    }

    public boolean hasNext() {
//        return (stack != null || current != null);
        return (!stack.isEmpty() || current != null);
    }

    public TreeNode next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        TreeNode result = current;
        current = current.right;
        return result;
    }
}
