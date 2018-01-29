package Ningbo.BinaryTreeAndDivideConquer;

import Ningbo.Util.TreeNode;

/**
 * Created by zhang on 6/24/16.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        //A or B 就是根节点,则返回根节点
        if (root == A || root == B) {
            return root;
        }

        //divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);


        if (left != null && right != null) {
            return root;
        }
        else if (left != null) {
            return left;
        }
        else if (right != null) {
            return right;
        }
        return null;
    }
}
