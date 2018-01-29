package Ningbo.BinaryTreeAndDivideConquer;

import Ningbo.Util.TreeNode;

/**
 * Created by zhang on 6/23/16.
 * Java中要注意NullPointerException 对null不能进行访问
 * 三层if else比较臭
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);

        boolean condLeft = false;
        boolean condRight = false;

        if (root.left == null) {
            condLeft = true;
        }
        else {
            if (root.left.val >= root.val) {
                condLeft = false;
            }
            else {
                if (root.left.right == null) {
                    condLeft = true;
                }
                else {
                    if (root.left.right.val < root.val) {
                        condLeft = true;
                    }
                }
            }

        }

        if (root.right == null) {
            condRight = true;
        }
        else {
            if (root.right.val <= root.val) {
                condRight = false;
            }
            else {
                if (root.right.left == null) {
                    condRight = true;
                }
                else {
                    if (root.right.left.val > root.val) {
                        condRight = true;
                    }
                }
            }
        }

        return left && right && condLeft && condRight;
    }
}
