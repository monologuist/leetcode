package Stack;

import java.util.Deque;
import java.util.LinkedList;

//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈
//思路：用两个栈实现，一个最小栈始终保证最小值在顶部
public class leetcode155 {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;


    public void MinStack(){
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x){
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop(){
        stack.pop();
        minStack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */