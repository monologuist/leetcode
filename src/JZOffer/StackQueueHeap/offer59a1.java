package JZOffer.StackQueueHeap;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
public class offer59a1 {
    /**
     * 思路：
     * 设窗口区间为[i,j] ，最大值为xj。当窗口向前移动一格，则区间变为[i+1,j+1] ，即添加了nums[j+1] ，删除了nums[i] 。
     * 若只向窗口[i,j] 右边添加数字nums[j+1] ，则新窗口最大值可以 通过一次对比 使用O(1) 时间得到，即：xj+1=max(xj,nums[j+1])
     * 而由于删除的nums[i] 可能恰好是窗口内唯一的最大值xj，因此不能通过以上方法计算xj+1，而必须使用O(j−i) 时间， 遍历整个窗口区间获取最大值，即：xj+1=max(nums(i+1),⋯,num(j+1))
     *
     * 本题难点： 如何在每次窗口滑动后，将 “获取窗口内最大值” 的时间复杂度从O(k) 降低至O(1) 。
     *
     * 窗口对应的数据结构为 双端队列 ，本题使用 单调队列 即可解决以上问题。遍历数组时，每轮保证单调队列deque ：
     * 1.deque 内 仅包含窗口内的元素⇒每轮窗口滑动移除了元素nums[i−1] ，需将deque 内的对应元素一起删除。
     * 2.deque 内的元素 非严格递减⇒每轮窗口滑动添加了元素nums[j+1] ，需将deque 内所有<nums[j+1] 的元素删除。
     *
     *
     * 算法流程：
     *
     * 1.初始化： 双端队列deque ，结果列表res ，数组长度n ；
     * 2.滑动窗口： 左边界范围i∈[1−k,n+1−k] ，右边界范围j∈[0,n−1] ；
     *     1.若i>0且队首元素deque[0]=被删除元素nums[i−1] ：则队首元素出队；
     *     2.删除deque内所有<nums[j]的元素，以保持deque 递减；
     *     3.将nums[j] 添加至deque 尾部；
     *     4.若已形成窗口（即i≥0 ）：将窗口最大值（即队首元素deque[0] ）添加至列表res 。
     * 3.返回值： 返回结果列表res 。
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //单调队列
        //下面是要注意的点：
        //队列按从大到小放入
        //如果首位值（即最大值）不在窗口区间，删除首位
        //如果新增的值小于队列尾部值，加到队列尾部
        //如果新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
        //如果新增值大于队列中所有值，删除所有，然后把新增值放到队列首位，保证队列一直是从大到小
        if (nums.length == 0)   return nums;

        Deque<Integer> deque = new LinkedList<>();
        int[] arr = new int[nums.length - k + 1];
        int index = 0;  //arr数组的下标
        //未形成窗口区间
        for (int i = 0; i < k; i++) {
            //队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            //一直循环删除到队列中的值都大于当前值，或者删到队列为空
            while (!deque.isEmpty() && nums[i] > deque.peekLast())  deque.removeLast();
            //执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
            deque.addLast(nums[i]);
        }
        //窗口区间刚形成后，把队列首位值添加到队列中
        //因为窗口形成后，就需要把队列首位添加到数组中，而下面的循环是直接跳过这一步的，所以需要我们直接添加
        arr[index++] = deque.peekFirst();
        //窗口区间形成
        for (int i = k; i < nums.length; i++) {
            //i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
            if (deque.peekFirst() == nums[i - k])   deque.removeFirst();
            //删除队列中比当前值大的值
            while (!deque.isEmpty() && nums[i] > deque.peekLast())  deque.removeLast();
            //把当前值添加到队列中
            deque.addLast(nums[i]);
            //把队列的首位值添加到arr数组中
            arr[index++] = deque.peekFirst();
        }
        return arr;
    }


    /**
     * 用堆的方法做：
     * 维护一个大小为窗口大小的大顶堆，顶堆元素则为当前窗口的最大值。
     *
     * 假设窗口的大小为 M，数组的长度为 N。在窗口向右移动时，需要先在堆中删除离开窗口的元素，并将新到达的元素添加到堆中，
     * 这两个操作的时间复杂度都为 log2M，因此算法的时间复杂度为 O(Nlog2M)，空间复杂度为 O(M)。
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }


    /**
     * int[]与ArrayList()
     * 这种做法相对来说执行用时比较久 内存消耗差距不大
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        // ArrayList<int[]> ret = new ArrayList<int[]>();
        int[] arr = new int[nums.length - k + 1];
        int index = 0;  //arr数组的下标
        if (k > nums.length || k < 1)
            return new int[0];
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < k; i++)
            heap.add(nums[i]);
        arr[index++] = heap.peek();
        for (int i = 0, j = i + k; j < nums.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(nums[i]);
            heap.add(nums[j]);
            arr[index++] = heap.peek();
        }
        return arr;

    }
}
