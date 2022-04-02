package DP.Backpack;
//背包问题2
//有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值. 问最多能装入背包的总价值是多大?
public class lintcode125 {
    /**
     * 常规思路
     */
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with V V[i]
     * @return: The maximum V
     */
    public int backPackII(int m, int[] A, int[] V) {
        int n = A.length;
        int[][] states = new int[n][m + 1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < m + 1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (A[0] <= m) {
            states[0][A[0]] = V[0];
        }
        for (int i = 1; i < n; ++i) {  // 动态规划，状态转移
            for (int j = 0; j <= m; ++j) {  // 不选择第i个物品
                if (states[i - 1][j] >= 0) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j <= m - A[i]; ++j) { // 选择第i个物品
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + V[i];
                    if (v > states[i][j + A[i]]) {
                        states[i][j + A[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxV = -1;
        for (int j = 0; j <= m; ++j) {
            if (states[n - 1][j] > maxV) {
                maxV = states[n - 1][j];
            }
        }
        return maxV;
    }

    /**
     * 优化解法
     */
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII1(int m, int[] A, int[] V) {
        return backPack(m, A, V);
    }

    private int backPack(int maxVolume, int[] volumes, int[] values) {
        int objectAmount = volumes.length;
        if (objectAmount == 0) {
            return 0;
        }
        int[] maxValuePerVolume = new int[maxVolume + 1];
        for (int cAmount = 0; cAmount < objectAmount; cAmount++) {
            for (int cVolume = maxVolume; cVolume > 0; cVolume--) {
                if (cVolume >= volumes[cAmount]) {
                    maxValuePerVolume[cVolume] = Math.max(maxValuePerVolume[cVolume], maxValuePerVolume[cVolume - volumes[cAmount]] + values[cAmount]);
                }
            }
        }
        return maxValuePerVolume[maxVolume];
    }
}
