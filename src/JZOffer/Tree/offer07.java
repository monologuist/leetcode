package JZOffer.Tree;

/**
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

import java.util.HashMap;

/**
 * 知识点：
 *
 * 前序遍历列表：第一个元素永远是 【根节点 (root)】
 * 中序遍历列表：根节点 (root)【左边】的所有元素都在根节点的【左分支】，【右边】的所有元素都在根节点的【右分支】
 * 算法思路：<分治法>
 *
 * 通过【前序遍历列表】确定【根节点 (root)】
 * 将【中序遍历列表】的节点分割成【左分支节点】和【右分支节点】
 * 递归寻找【左分支节点】中的【根节点 (left child)】和 【右分支节点】中的【根节点 (right child)】
 */
public class offer07 {
    int[] preorder;
    HashMap<Integer,Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i],i);
        }
        return recur(0,0,inorder.length - 1);
    }

    TreeNode recur(int root,int left,int right){
        //递归终止
        if (left > right) return null;
        //建立根节点
        TreeNode node = new TreeNode(preorder[root]);
        //划分根节点、左子树、右子树
        int i = dic.get(preorder[root]);
        //开启左子树递归
        node.left = recur(root + 1,left,i - 1);
        //开启右子树递归
        node.right = recur(root + i - left + 1,i + 1,right);
        //回溯返回根节点
        return node;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }