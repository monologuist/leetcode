package JZOffer.StackQueueHeap;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。（同leetcode232题）
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
public class offer09 {
    /**
     * 思路：
     * 加入队尾 appendTail()函数： 将数字 val 加入栈 A 即可。
     * 删除队首deleteHead()函数： 有以下三种情况。
     * 1.当栈 B 不为空： B中仍有已完成倒序的元素，因此直接返回 B 的栈顶元素。
     * 2.否则，当 A 为空： 即两个栈都为空，无元素，因此返回−1 。
     * 3.否则： 将栈 A 元素全部转移至栈 B 中，实现元素倒序，并返回栈 B 的栈顶元素。
     *
     */

     LinkedList<Integer> list1,list2;

    public offer09() {
        list1 = new LinkedList<Integer>();
        list2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        list1.addLast(value);
    }

    public int deleteHead() {
        if (list1.isEmpty()){
            return -1;
        }
        if (!list2.isEmpty()){
            return list2.removeLast();
        }
        while (!list1.isEmpty()){
            list2.addLast(list1.removeLast());
        }
        return list2.removeLast();

    }

/**
 * in 栈用来处理入栈（push）操作，out 栈用来处理出栈（pop）操作。
 * 一个元素进入 in 栈之后，出栈的顺序被反转。
 * 当元素要出栈时，需要先进入 out 栈，此时元素出栈顺序再一次被反转，
 * 因此出栈顺序就和最开始入栈顺序是相同的，先进入的元素先退出，这就是队列的顺序。
 */
class CQueue {
    Stack<Integer> in, out;

    public CQueue() {
        in = new Stack<Integer>();
        out = new Stack<Integer>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty())
                out.push(in.pop());
        }
        if (out.isEmpty()) {
            return -1;
        }
        ;

        return out.pop();
    }
}

}
