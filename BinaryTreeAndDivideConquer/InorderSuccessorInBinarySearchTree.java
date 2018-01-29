package Ningbo.BinaryTreeAndDivideConquer;

import Ningbo.Util.TreeNode;

import java.util.ArrayList;

/**
 * Created by zhang on 6/23/16.
 * 构造inorder数组
 */
public class InorderSuccessorInBinarySearchTree {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> inorderList = inorderList(root);
        if (inorderList == null) {
            return null;
        }
        if (!inorderList.contains(p)) {
            return null;
        }
        if (inorderList.indexOf(p) == inorderList.size() - 1) {
            return null;
        }
        return inorderList.get(inorderList.indexOf(p) + 1);
    }

    private ArrayList<TreeNode> inorderList(TreeNode root) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> left = inorderList(root.left);
        ArrayList<TreeNode> right = inorderList(root.right);
        result.addAll(left);
        result.add(root);
        result.addAll(right);
        return result;
    }
}
