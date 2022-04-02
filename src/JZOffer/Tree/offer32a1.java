package JZOffer.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 * 解题思路：
 * 题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
 * BFS 通常借助 队列 的先入先出特性来实现。
 */
public class offer32a1 {
    /**
     * 算法流程：
     * 特例处理： 当树的根节点为空，则直接返回空列表 [] ；
     * 初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
     * BFS 循环： 当队列 queue 为空时跳出；
     * 出队： 队首元素出队，记为 node；
     * 打印： 将 node.val 添加至列表 tmp 尾部；
     * 添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
     * 返回值： 返回打印结果列表 res 即可。
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null)
                    continue;
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        int[] res = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            res[i] = ret.get(i);
        }return res;
    }
}
