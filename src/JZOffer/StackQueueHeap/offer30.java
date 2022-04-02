package JZOffer.StackQueueHeap;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈
 * 思路：用两个栈实现，一个最小栈始终保证最小值在顶部
 *
 * 数据栈A ： 栈A 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
 * 辅助栈B ： 栈B 中存储栈A 中所有 非严格降序 的元素，则栈A 中的最小元素始终对应栈B 的栈顶元素，即 min() 函数只需返回栈B 的栈顶元素即可。
 *
 */
public class offer30 {
    /**
     * 函数设计：
     * push(x) 函数： 重点为保持栈B 的元素是 非严格降序 的。
     * 1.将x 压入栈A （即 A.add(x) ）；
     * 2.若 ① 栈B 为空 或 ②x 小于等于 栈B 的栈顶元素，则将x 压入栈B （即 B.add(x) ）。
     * pop() 函数： 重点为保持栈A,B 的 元素一致性 。
     * 1.执行栈A 出栈（即 A.pop() ），将出栈元素记为y ；
     * 2.若y 等于栈B 的栈顶元素，则执行栈 B 出栈（即 B.pop() ）。
     * top() 函数： 直接返回栈A 的栈顶元素即可，即返回 A.peek() 。
     * min() 函数： 直接返回栈B 的栈顶元素即可，即返回 B.peek() 。
     *
     */
    Stack<Integer> A, B;
    public offer30() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
}
