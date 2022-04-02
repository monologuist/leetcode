package JZOffer.Tree;

/**
 * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 二叉树镜像定义： 对于二叉树中任意节点root ，设其左 / 右子节点分别为left,right ；则在二叉树的镜像中的对应root 节点，其左 / 右子节点分别为right,left 。
 */
public class offer27 {
    /**
     * 方法一：递归法
     *
     * 根据二叉树镜像的定义，考虑递归遍历（dfs）二叉树，交换每个节点的左 / 右子节点，即可生成二叉树的镜像。
     * 递归解析：
     *
     * 终止条件： 当节点root 为空时（即越过叶节点），则返回null ；
     * 递推工作：
     * 初始化节点tmp ，用于暂存root 的左子节点；
     * 开启递归 右子节点mirrorTree(root.right) ，并将返回值作为root 的 左子节点 。
     * 开启递归 左子节点mirrorTree(tmp) ，并将返回值作为root 的 右子节点 。
     * 返回值： 返回当前节点root ；
     * Q： 为何需要暂存root 的左子节点？
     * A： 在递归右子节点 “root.left=mirrorTree(root.right);” 执行完毕后，root.left 的值已经发生改变，此时递归左子节点mirrorTree(root.left) 则会出问题。
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
