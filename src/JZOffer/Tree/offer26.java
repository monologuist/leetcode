package JZOffer.Tree;

/**
 * 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * 示例：输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class offer26 {
    /**
     * 思路：
     * 若树B 是树A 的子结构，则子结构的根节点可能为树A 的任意一个节点。因此，判断树B 是否是树A 的子结构，需完成以下两步工作：
     * 先序遍历树A 中的每个节点nA；（对应函数 isSubStructure(A, B)）
     * 判断树A 中 以nA为根节点的子树 是否包含树B 。（对应函数 recur(A, B)）
     *
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     *
     * @param A
     * @param B
     * @return
     */
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
