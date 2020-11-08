package Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
public class leetcode102 {
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                // 将这一层的节点存起来
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                lists.add(list);
            }
            return lists;
        }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }