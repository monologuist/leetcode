package DP.Sequence;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 对于数组 [2,3,1,2,4,2,3]，初始位置是下标 0，
 * 从下标 0 出发，最远可到达下标 2。
 * 下标 0 可到达的位置中，下标 1 的值是 3，从下标 1 出发可以达到更远的位置，
 * 因此第一步到达下标 1。 从下标 1 出发，最远可到达下标 4。
 * 下标 1 可到达的位置中，下标 4 的值是 4 ，从下标 4 出发可以达到更远的位置，因此第二步到达下标 4。
 *
 * 我们维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1。
 */
public class leetcode45 {
    public int jump(int[] nums) {
        int len = nums.length;
        int end = 0;  // 判断是否到达上一个最大边界
        int maxPosition = 0;  // 当前能跳到的最大位置
        int steps = 0;  // 记录跳的次数，
        String test = "test";
        for (int i = 0; i < len - 1; ++i) {
            maxPosition = Math.max(maxPosition, i + nums[i]); // 更新最大边界
            if (i == end) { // 如果到达上一个最大边界，更新数据，说明从上个位置一步可以跳到这里
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
