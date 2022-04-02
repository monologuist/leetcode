package DP.Sequence;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 对于当前遍历到的位置 ，如果它在最远可以到达的位置的范围内，
 * 那么我们就可以从起点通过若干次跳跃到达该位置，
 * 因此我们可以用 x+nums[x]更新最远可以到达的位置。
 * if (i <= rightmost) 这句判断就是起到了题解中这句话的作用。
 * 举个例子，nums=[1,0,2,3]，那么当i=2时rightmost=1，
 * 此时i>rightmost，表明我们无法到达index=2的位置，也就无法更新rightmost了。
 */
public class leetcode55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightMost) {  // 如果i > rightMost，说明到不了rightMost，不更新
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
