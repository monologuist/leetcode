package DP.Backpack;

//在 n 个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为 m，每个物品的大小为 A[i]
public class lintcode92 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int n = A.length;
        boolean[] states = new boolean[m + 1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (A[0] <= m) {
            states[A[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = m - A[i]; j >= 0; --j) { //把第i个物品放入背包
                if (states[j] == true) {
                    states[j + A[i]] = true;
                }
            }
        }
        for (int i = m; i >= 0; --i) { // 输出结果
            if (states[i] == true) return i;
        }
        return 0;
    }
}
