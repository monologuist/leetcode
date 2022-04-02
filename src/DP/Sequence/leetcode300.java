package DP.Sequence;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 最长上升子序列（Longest Common Subsequence，简称 LCS）：经典动态规划及面试问题
 *
 *
 * 1。只用DP做
 * 定义dp[i]为考虑前i个元素，以第i个数字结尾的最长上升子序列的长度，注意nums[i]必须被选取
 * 计算到dp[i]时我们已经计算出dp[0..i-1]的值
 * 状态转移方程：dp[i]=max(dp[j])+1   0<j<i 且 num[j]<num[i]
 * 即考虑往dp[0...i-1]中最长的上升子序列后面再加一个nums[i]
 * 由于dp[j]代表nums[0...j]中以nums[j]结尾的最长上升子序列，所以如果能够从dp[j]这个状态转移过来
 * 那么nums[i]必然要大于nums[j]，才能将nums[i]放在nums[j]后面以形成更长的上升子序列
 *
 * 最后，整个数组的最长上升子序列即所有dp[i]中的最大值：LISlength = max(dp[i]) 0<=i<n
 */
public class leetcode300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    /**
     * 动态规划+二分查找
     */
    public int lengthOfLIS0(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return 0;
        }
        int[] tails = new int[n];
        int maxLength = 0;
        for (int num : nums) {
            int index = binarySearch(tails, maxLength, num);
            tails[index] = num;
            if (index == maxLength) {
                maxLength++;
            }
        }
        return maxLength;
    }
    private int binarySearch(int[] tails, int len, int key) {
        int left = 0, right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] == key) {
                return mid;
            } else if (tails[mid] > key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
