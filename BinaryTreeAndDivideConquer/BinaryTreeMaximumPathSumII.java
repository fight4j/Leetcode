package Ningbo.BinaryTreeAndDivideConquer;

import Ningbo.Util.TreeNode;

/**
 * Created by zhang on 6/22/16.
 * 落下了负数的情况,如果是负数,不如不加
 */
public class BinaryTreeMaximumPathSumII {
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + Math.max(0, Math.max(maxPathSum2(root.left), maxPathSum2(root.right)));
    }
}
