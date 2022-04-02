package DP.TwoSequencesDP;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * 通过300、1143、72掌握LCS问题
 * https://leetcode-cn.com/problems/longest-common-subsequence/solution/dong-tai-gui-hua-zhi-zui-chang-gong-gong-zi-xu-lie/
 * 1.定dp数组的含义：dp[i][j]：对于s1[1...i]和s2[1...j]，它们的LCS长度是dp[i][j]
 * 2.定义base case：让索引为 0 的行和列表示空串，dp[0][..] 和 dp[..][0] 都应该初始化为 0
 * 3.找状态转移方程（简单来讲就是做选择）：
 * 这个问题，是求 s1 和 s2 的最长公共子序列，不妨称这个子序列为 lcs。那么对于 s1 和 s2 中的每个字符，有什么选择？很简单，两种选择，要么在 lcs 中，要么不在。
 * 这个「在」和「不在」就是选择，关键是，应该如何选择呢？
 * 这个需要动点脑筋：如果某个字符应该在 lcs 中，那么这个字符肯定同时存在于 s1 和 s2 中，因为 lcs 是最长公共子序列嘛。
 *
 * 故本题思路是：
 * 用两个指针 i 和 j 从后往前遍历 s1 和 s2，如果 s1[i]==s2[j]，那么这个字符一定在 lcs 中；
 * 否则的话，s1[i] 和 s2[j] 这两个字符至少有一个不在 lcs 中，需要丢弃一个。
 *
 * 先看一下递归的解法，比较容易理解：<这段就是暴力解法>
 *  def longestCommonSubsequence(str1, str2) -> int:
 *     def dp(i, j):
 *         # 空串的 base case
 *         if i == -1 or j == -1:
 *             return 0
 *         if str1[i] == str2[j]:
 *             # 这边找到一个 lcs 的元素，继续往前找
 *             return dp(i - 1, j - 1) + 1
 *         else:
 *             # 谁能让 lcs 最长，就听谁的
 *             return max(dp(i-1, j), dp(i, j-1))
 *
 *     # i 和 j 初始化为最后一个索引
 *     return dp(len(str1)-1, len(str2)-1)
 *
 *
 * 下面考虑用备忘录/DP table来优化时间复杂度
 *
 */
public class leetcode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        //构建 DP table 和 base case
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; ++j) {
                //找到一个 lcs 中的字符
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
