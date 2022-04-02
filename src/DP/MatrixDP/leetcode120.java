package DP.MatrixDP;

//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
//相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

import java.util.List;

public class leetcode120 {
    // int row;
    // Integer[][] memo;

    // public int minimumTotal(List<List<Integer>> triangle) {
    //     row = triangle.size();
    //     memo = new Integer[row][row];
    //     return helper(0,0, triangle);
    // }

    // private int helper(int level, int c, List<List<Integer>> triangle){
    //     if (memo[level][c]!=null)
    //         return memo[level][c];
    //     if (level==row-1){
    //         return memo[level][c] = triangle.get(level).get(c);
    //     }
    //     int left = helper(level+1, c, triangle);
    //     int right = helper(level+1, c+1, triangle);
    //     return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);
    // }

    //动态规划
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {  // 第i行有i个数
                // 这里变成一位数组，因为层号实际上可以不用记录，每次记录上一层的值，到当前层就把以前的覆盖到，动态规划运用场景其中一条就是最优子结构，往下走不用回头一定是最优的
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(level).get(i);
            }
        }
        return dp[0];
    }
}
