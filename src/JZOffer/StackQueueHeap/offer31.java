package JZOffer.StackQueueHeap;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
 *
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 */
public class offer31 {
    /**
     * 思路：
     * 判断合不合法，用个栈试一试:
     * 把压栈的元素按顺序压入，当栈顶元素和出栈的第一个元素相同，则将该元素弹出，
     * 出栈列表指针后移并继续判断。最后判断出栈列表指针是否指向出栈列表的末尾即可。
     */

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        for (int num : pushed) {
            stack.push(num);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
//        return j == popped.length;
        return stack.isEmpty();
    }

/**
 * 关于使用Queue代替stack的问题：
 * 这个是Java历史遗留问题，Stack继承了Vector且是Vector的唯一子类，Vector逐渐被Java抛弃了，
 * 且Stack是实体类，Deque是一个通用接口，使用起来更灵活，
 * 查Java api中java.util.Stack中官方文档也给出了使用Deque来代替Stack的建议。
 *
 * 当然，使用LinkedList也同理。
 */
}
