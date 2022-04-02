package JZOffer.StackQueueHeap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 类型同offer40
 */
public class leetcode215 {
    /**
     * 方法：采用优先队列来做。小根堆排序
     * 优先队列的思路是很朴素的。因为第 K 大元素，其实就是整个数组排序以后后半部分最小的那个元素。因此，我们可以维护一个有 K 个元素的最小堆：
     * 1、如果当前堆不满，直接添加；
     * 2、堆满的时候，如果新读到的数小于等于堆顶，肯定不是我们要找的元素，只有新都到的数大于堆顶的时候，才将堆顶拿出，然后放入新读到的数，进而让堆自己去调整内部结构。
     *
     * 说明：这里最合适的操作其实是 replace，即直接把新读进来的元素放在堆顶，然后执行下沉（siftDown）操作。Java 当中的 PriorityQueue 没有提供这个操作，只好先 poll() 再 offer()。
     *
     * 优先队列的写法就很多了，这里例举一下我能想到的（以下的写法大同小异，没有本质差别）。
     * 假设数组有 len 个元素。
     * 思路1：把 len 个元素都放入一个最小堆中，然后再 pop() 出 len - k 个元素，此时最小堆只剩下 k 个元素，堆顶元素就是数组中的第 k 个最大元素。
     * 思路2：把 len 个元素都放入一个最大堆中，然后再 pop() 出 k - 1 个元素，因为前 k - 1 大的元素都被弹出了，此时最大堆的堆顶元素就是数组中的第 k 个最大元素。
     * 思路 3：只用 k 个容量的优先队列，而不用全部 len 个容量。
     * 思路 4：用 k + 1 个容量的优先队列，使得上面的过程更“连贯”一些，到了 k 个以后的元素，就进来一个，出去一个，让优先队列自己去维护大小关系。
     * 思路 5：综合考虑以上两种情况，总之都是为了节约空间复杂度。即 k 较小的时候使用最小堆，k 较大的时候使用最大堆。
     * @param nums
     * @param k
     * @return
     */

    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 len 个元素的最小堆，默认是最小堆，可以不写 lambda 表达式：(a, b) -> a - b
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, (a, b) -> a - b);
        for (int i = 0; i < len; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = 0; i < len - k; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 len 个元素的最大堆，lambda 表达式应写成：(a, b) -> b - a
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a, b) -> b - a);
        for (int i = 0; i < len; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public int findKthLargest3(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            // 看一眼，不拿出，因为有可能没有必要替换
            Integer topEle = minHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topEle) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public int findKthLargest4(int[] nums, int k) {
        int len = nums.length;
        // 最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1, (a, b) -> (a - b));
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            priorityQueue.add(nums[i]);
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }




    /**
     *
     *
     * 根据 k 的不同，选最大堆和最小堆，目的是让堆中的元素更小
     *      思路 1：k 要是更靠近 0 的话，此时 k 是一个较小的数，用最大堆
     *      例如在一个有 6 个元素的数组里找第 5 大的元素
     *      思路 2：k 要是更靠近 len 的话，用最小堆
     *
     *      所以分界点就是 k = len - k
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest5(int[] nums, int k) {
        int len = nums.length;
        if (k <= len - k) {
            // System.out.println("使用最小堆");
            // 特例：k = 1，用容量为 k 的最小堆
            // 使用一个含有 k 个元素的最小堆
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
            for (int i = 0; i < k; i++) {
                minHeap.add(nums[i]);
            }
            for (int i = k; i < len; i++) {
                // 看一眼，不拿出，因为有可能没有必要替换
                Integer topEle = minHeap.peek();
                // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
                if (nums[i] > topEle) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
            return minHeap.peek();

        } else {
            // System.out.println("使用最大堆");
            assert k > len - k;
            // 特例：k = 100，用容量为 len - k + 1 的最大堆
            int capacity = len - k + 1;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(capacity, (a, b) -> b - a);
            for (int i = 0; i < capacity; i++) {
                maxHeap.add(nums[i]);
            }
            for (int i = capacity; i < len; i++) {
                // 看一眼，不拿出，因为有可能没有必要替换
                Integer topEle = maxHeap.peek();
                // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
                if (nums[i] < topEle) {
                    maxHeap.poll();
                    maxHeap.add(nums[i]);
                }
            }
            return maxHeap.peek();
        }
    }


}
