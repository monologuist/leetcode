package Stack;




import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//给定一个二叉树，返回它的中序遍历。
//// 思路：通过stack 保存已经访问的元素，用于原路返回
public class leetcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new LinkedList<>();
        }
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node!=null){
                stack.addLast(node);
                node = node.left;
            }
            node = stack.removeLast();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
}
/**
 * Definition for a binary tree node.
 *  */
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
