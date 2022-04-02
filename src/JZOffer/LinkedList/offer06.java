package JZOffer.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例：输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class offer06 {
    /**
     * 方法1：递归法
     * Java 算法流程：
     * 1.递推阶段： 每次传入 head.next ，以 head == null（即走过链表尾部节点）为递归终止条件，此时直接返回。
     * 2.回溯阶段： 层层回溯时，将当前节点值加入列表，即tmp.add(head.val)。
     * 3.最终，将列表 tmp 转化为数组 res ，并返回即可。
     * 复杂度分析：
     * 时间复杂度O(N)： 遍历链表，递归N 次。
     * 空间复杂度O(N)： 系统递归需要使用O(N) 的栈空间。
     * @param head
     * @return
     */
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }


    /**
     * 方法2：辅助栈法
     * 解题思路：
     * 链表特点： 只能从前至后访问每个节点。
     * 题目要求： 倒序输出节点值。
     * 这种 先入后出 的需求可以借助 栈 来实现。
     *
     * 算法流程：
     * 入栈： 遍历链表，将各节点值 push 入栈。（Python​ 使用 append() 方法，​Java​借助 LinkedList 的addLast()方法）。
     * 出栈： 将各节点值 pop 出栈，存储于数组并返回。（Python​ 直接返回 stack 的倒序列表，Java ​新建一个数组，通过 popLast() 方法将各元素存入数组，实现倒序输出）。
     * 复杂度分析：
     * 时间复杂度O(N)： 入栈和出栈共使用O(N) 时间。
     * 空间复杂度O(N)： 辅助栈 stack 和数组 res 共使用O(N) 的额外空间。
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();

        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }



    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }


}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }