package Ningbo.BinaryTreeAndDivideConquer;

import Ningbo.Util.TreeNode;
import java.util.ArrayList;

/**
 * Created by zhang on 6/22/16.
 * Traversal的代码需要补充
 */
public class BinaryTreePreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}
