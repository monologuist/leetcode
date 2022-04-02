package DP.Sequence;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class leetcode70 {

        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            int pre1 = 1, pre2 = 2;
            for (int i = 2; i < n; ++i) {
                int cur = pre1 + pre2;
                pre1 = pre2;
                pre2 = cur;
            }
            return pre2;
        }

    /**
     * let dp = new Array(n + 1);
     *     dp[0] = 1;
     *     dp[1] = 2;
     *     for (let i = 2; i <= n; i ++) {
     *         dp[i] = dp[i - 1] + dp[i - 2];
     *     }
     *     return dp[n - 1];
     *
     */
}
