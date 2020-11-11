package DP;

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//说明：每次只能向下或者向右移动一步。
public class leetcode64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        if (n == 1) {
            return grid[0][0];
        }
        int[][] result = new int[m][n];
        result[0][0] = grid[0][0];
        // 处理边界
        for (int i = 1; i < n; ++i) {
            result[0][i] = grid[0][i] + result[0][i-1];
        }
        for (int i = 1; i < m; ++i) {
            result[i][0] = grid[i][0] + result[i-1][0];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                result[i][j] = Math.min(grid[i][j] + result[i-1][j], grid[i][j] + result[i][j-1]);
            }
        }
        return result[m-1][n-1];
    }


    public int minPathSum1(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}
