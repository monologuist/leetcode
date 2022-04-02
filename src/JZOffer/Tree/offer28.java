package JZOffer.Tree;

/**
 * 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class offer28 {
    /**
     * 解题思路：
     *
     * 对称二叉树定义： 对于树中 任意两个对称节点L 和R ，一定有：
     * L.val=R.val ：即此两对称节点值相等。
     * L.left.val=R.right.val ：即L 的 左子节点 和R 的 右子节点 对称；
     * L.right.val=R.left.val ：即L 的 右子节点 和R 的 左子节点 对称。
     * 根据以上规律，考虑从顶至底递归，判断每对节点是否对称，从而判断树是否为对称二叉树。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left,root.right);
    }

    /**
     * 算法流程：
     *
     * isSymmetric(root) ：
     * 特例处理： 若根节点 root 为空，则直接返回true 。
     * 返回值： 即 recur(root.left, root.right) ;
     * recur(L, R) ：
     * 终止条件：
     * 当L 和R 同时越过叶节点： 此树从顶至底的节点都对称，因此返回true ；
     * 当L 或R 中只有一个越过叶节点： 此树不对称，因此返回false ；
     * 当节点L 值≠节点R 值： 此树不对称，因此返回false ；
     * 递推工作：
     * 判断两节点L.left 和R.right 是否对称，即 recur(L.left, R.right) ；
     * 判断两节点L.right 和R.left 是否对称，即 recur(L.right, R.left) ；
     * 返回值： 两对节点都对称时，才是对称树，因此用与逻辑符 && 连接。
     * @param L
     * @param R
     * @return
     */
    public boolean recur(TreeNode L,TreeNode R){
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left,R.right) && recur(L.right,R.left);
    }
/**
 * 借由此题引出对递归的一些思考：
 * 做递归思考三步：
 *
 * 递归的函数要干什么？
 * 函数的作用是判断传入的两个树是否镜像。
 * 输入：TreeNode left, TreeNode right
 * 输出：是：true，不是：false
 * 递归停止的条件是什么？
 * 左节点和右节点都为空 -> 倒底了都长得一样 ->true
 * 左节点为空的时候右节点不为空，或反之 -> 长得不一样-> false
 * 左右节点值不相等 -> 长得不一样 -> false
 * 从某层到下一层的关系是什么？
 * 要想两棵树镜像，那么一棵树左边的左边要和二棵树右边的右边镜像，一棵树左边的右边要和二棵树右边的左边镜像
 * 调用递归函数传入左左和右右
 * 调用递归函数传入左右和右左
 * 只有左左和右右镜像且左右和右左镜像的时候，我们才能说这两棵树是镜像的
 * 调用递归函数，我们想知道它的左右孩子是否镜像，传入的值是root的左孩子和右孩子。这之前记得判个root==null。
 */
}
