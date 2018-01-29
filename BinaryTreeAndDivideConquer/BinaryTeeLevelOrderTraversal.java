package Ningbo.BinaryTreeAndDivideConquer;

import Ningbo.Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 6/26/16.
 * root后,所有访问到的节点先出队列,并加到结果集,检查左右子树是否为空,否则加入队列
 * 队列永远只维护下一level的节点
 */
public class BinaryTeeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int qsize = q.size();
            ArrayList<Integer> currentLevelList = new ArrayList<Integer>();
            for (int i = 0; i < qsize; i++) {
                TreeNode node = q.poll();
                currentLevelList.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(currentLevelList);
        }
        return result;
    }
}
