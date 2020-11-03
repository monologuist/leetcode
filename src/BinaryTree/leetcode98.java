package BinaryTree;

public class leetcode98 {
    private boolean helper (TreeNode node,Integer lower,Integer upper){
        if (node == null){
            return true;
        }
        int val = node.val;
        if ((lower != null && val <= lower)||(upper != null && val >= upper)){
            return false;
        }
        return helper(node.right,val,upper) && helper(node.left,lower,val);
    }

    public boolean isValidBST(TreeNode root){
        return helper(root,null,null);
    }
}
