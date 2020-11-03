package Stack;

import java.util.Deque;
import java.util.LinkedList;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
public class leetcode84 {
    //暴力解法
    public int largestRectangleArea0(int[] heights) {
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {

            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }

            // 找右边最后 1 个大于等于 heights[i] 的索引
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight) {
                right++;
            }

            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;
    }

    //使用单调栈
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; ++i) {
            newHeights[i + 1] = heights[i];
        }
        int maxArea = 0;
        len += 2;
        heights = newHeights;
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(0);
        for (int i = 1; i < len; ++i) {
            while (heights[stack.peekFirst()] > heights[i]) {
                int height = heights[stack.removeFirst()];
                int width = i - stack.peekFirst() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.addFirst(i);
        }
        return maxArea;
    }

}
