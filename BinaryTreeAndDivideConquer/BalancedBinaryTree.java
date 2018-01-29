package Ningbo.BinaryTreeAndDivideConquer;

import Ningbo.Util.TreeNode;

/**
 * Created by zhang on 6/21/16.
 */

class Result {
    public boolean isBalanced;
    public int depth;
    public Result(boolean isBalanced, int depth) {
        this.isBalanced = isBalanced;
        this.depth = depth;
    }
}

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    public Result helper(TreeNode root) {
        if (root == null) {
            return new Result(true, 0);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.depth - right.depth) < 2;
        int depth = Math.max(left.depth, right.depth) + 1;
        return new Result(isBalanced, depth);
    }
}
