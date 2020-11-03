package BinaryTree;

public class leetcode124 {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node){
        if (node == null){
            return 0;
        }
        //对负数进行处理
        int leftmaxGain = Math.max(maxGain(node.left), 0);
        int rightmaxGain = Math.max(maxGain(node.right), 0);

        int curMaxSum = node.val + leftmaxGain + rightmaxGain;

        maxSum = Math.max(maxSum, curMaxSum);

        return node.val+Math.max(leftmaxGain,rightmaxGain);
    }
}

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }