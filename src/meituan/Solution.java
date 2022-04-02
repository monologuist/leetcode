package meituan;

/**
 * 最佳观光组合
 *
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 *
 * 思想：
 * 使用 max 记录当前下标的最大值， preMax 记录当前下标前面范围的最大值。
 *
 */
public class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int max = 0;
        int preMax = A[0] + 0;
        for (int i = 1, length = A.length; i < length; i++) {
            max = Math.max(max, preMax + A[i] - i);
            preMax = Math.max(preMax, A[i] + i);
        }
        return max;
    }
}
