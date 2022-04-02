package DP.TwoSequencesDP;

/**
 * 编辑距离
 * 给你两个单词  word1 和  word2，
 * 请你计算出将  word1  转换成  word2 所使用的最少操作数
 * 你可以对一个单词进行如下三种操作： 插入一个字符 删除一个字符 替换一个字符
 *
 * 思路：和上题很类似，相等则不需要操作，否则取删除、插入、替换最小操作次数的值+1
 */
public class leetcode72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; ++i) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
