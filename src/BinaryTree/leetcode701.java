package BinaryTree;//给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
//思路：找到最后一个叶子节点满足插入条件即可

// DFS查找插入位置
public class leetcode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        //如果要插入的值比根节点的值大，那把它放在根节点的右子树中，再递归判断
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            //否则把它放在根节点的左子树中，再递归判断
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
