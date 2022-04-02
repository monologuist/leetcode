package JZOffer.StackQueueHeap;

import java.util.PriorityQueue;

/**
 * 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 *
 * 如何得到一个数据流中的中位数
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 思路：用堆
 * 用大顶堆+小顶堆方法，可以看作大顶堆是普通班，小顶堆是实验班。数量上时刻保持 小顶-大顶<=1（两堆相等或者小顶比大顶多一个）。
 * 新学生先入普通班（大顶堆），此时可能会失去平衡了，
 * 于是取大顶堆的第一个（班里最好的学生）加入实验班（小顶堆），
 * 判断若数量过多（不是等于或多一个），
 * 取第一个（实验班里最差的学生）到普通班（大顶堆）里。
 * 取中位数的时候，若两堆数量相等，则各取堆顶取平均，若小顶比大顶多一，则多的那一个就是中位数。
 */
public class offer41a1 {
    PriorityQueue<Integer> left;//大顶
    PriorityQueue<Integer> right;//小顶
    /** initialize your data structure here. */
    public offer41a1() {
        /** 大顶堆，存储左半边元素 */
        left=new PriorityQueue<>((n1,n2)->n2-n1);
        /** 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
        right=new PriorityQueue<>();
    }

    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if(left.size()+1<right.size())
            left.add(right.poll());
    }

    public double findMedian() {
        if(right.size()>left.size())return right.peek();
        return (double)(left.peek()+right.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

