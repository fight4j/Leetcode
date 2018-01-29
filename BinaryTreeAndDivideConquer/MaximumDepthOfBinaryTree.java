package Ningbo.BinaryTreeAndDivideConquer;

import Ningbo.Util.TreeNode;

/**
 * Created by zhang on 6/21/16.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
