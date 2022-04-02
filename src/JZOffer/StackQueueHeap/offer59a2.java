package JZOffer.StackQueueHeap;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例：输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 */
public class offer59a2 {
    /**
     * 其实本质上是一个求滑动窗口最大值的问题。
     * 这个队列可以看成是一个滑动窗口，入队就是将窗口的右边界右移，出队就是将窗口的左边界右移。
     *
     * 既然是求解滑动窗口的最大值问题，那就变成了模板题，直接套单调队列模板即可。
     */
    private Deque<Integer> queue;
    private Deque<Integer> help;

    public offer59a2() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : help.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(!help.isEmpty() && value > help.peekLast()) {
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        }
        int val = queue.pop();
        if(help.peek() == val) {
            help.pop();
        }
        return val;
    }


/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
}
