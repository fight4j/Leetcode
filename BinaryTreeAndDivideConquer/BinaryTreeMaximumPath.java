package Ningbo.BinaryTreeAndDivideConquer;

import Ningbo.Util.TreeNode;

/**
 * Created by zhang on 6/24/16.
 * 错误答案误将左右子树加入,一旦向上递归时会导致path无法走通,是错误答案
 *
 * * 此题原本没有太多思路,参考他人写法而写
 * 1.recursionMax代表某节点的单路path (左子树或右子树或空 + 该节点)
 * 2.crossMax 代表跨越该节点的值,即 左 + 右 + 该节点
 * 3.max为全局变量,为上两个值得较大者,需刚开始复制为无穷小(否则为被置为0!!!)
 * recursionMax为可以向上递归的值,crossMax跨越值无法向上传递给父节点
 *
 * 二叉树思路:考虑总结果与左子树\右子树的结果之间的关系
 *
 * 该题关键为crossMax无法向上传递,所以Max也无法向上传递
 */
public class BinaryTreeMaximumPath {
    //跨越节点的这种情况的最大值,无法向上递归

//    public int maxPathSum(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int left = maxPathSum(root.left);
//        int right = maxPathSum(root.right);
//        return Math.max(root.val, 0) + Math.max(left, 0) + Math.max(right, 0);
//    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        int recursionMax = Math.max(root.val, Math.max(left, right) + root.val);
        int cross = left + right + root.val;
        max = Math.max(max, Math.max(recursionMax, cross));
        return recursionMax;
    }
}
