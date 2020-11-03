package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode103 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root == null) {
                return lists;
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            boolean flag = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (!flag) {
                        // flag 为false, 需要从右往左遍历，这里直接插入首部，实现翻转的效果。也可以再插入完一层后，直接reverse()
                        list.add(0, node.val);
                    } else {
                        list.add(node.val);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                if (!flag) {
                    flag = true;
                } else {
                    flag = false;
                }
                lists.add(list);
            }
            return lists;
        }
}
