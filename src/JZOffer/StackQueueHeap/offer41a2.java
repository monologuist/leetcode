package JZOffer.StackQueueHeap;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 本题也是offer50题
 * 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class offer41a2 {
    /**
     * 使用统计数组来统计每个字符出现的次数，本题涉及到的字符为都为 ASCII 码，
     * 因此使用一个大小为 128 的整型数组就能完成次数统计任务。
     *
     * 使用队列来存储到达的字符，并在每次有新的字符从字符流到达时
     * 移除队列头部那些出现次数不再是一次的元素。
     * 因为队列是先进先出顺序，因此队列头部的元素为第一次只出现一次的字符。
     */

    private int[] cnts = new int[128];
    private Queue<Character> queue = new LinkedList<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1)
            queue.poll();
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
