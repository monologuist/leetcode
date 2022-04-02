package AlibabaCloud;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode21：合并两个有序链表
 */
public class mergeKLists {
    /**
     * 用容量为K的最小堆优先队列，把链表的头结点都放进去，然后出队当前优先队列中最小的，挂上链表，
     * 然后让出队的那个节点的下一个入队，再出队当前优先队列中最小的，直到优先队列为空。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length == 0){//输入：lists = [] 输出：[]，特例1判断
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue pq = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return o1.val - o2.val;//返回升序排列
                    }
                });

        for (ListNode list: lists) {//遍历给定链表数组中的每个链表
            if (list == null){//输入：lists = [[]] 输出：[]，特例2判断
                continue;
            }
            pq.add(list);//都放进优先队列中
        }

        while (!pq.isEmpty()){//优先队列不为空
            ListNode nextNode = (ListNode) pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null){
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }

}

class ListNode{
    int val;
    ListNode next;

    ListNode(){}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
