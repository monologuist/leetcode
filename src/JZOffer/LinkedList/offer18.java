package JZOffer.LinkedList;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/solution/shuang-zhi-zhen-he-di-gui-liang-chong-fang-shi-jie/
 * 删除链表的节点
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 *
 */
public class offer18 {
    /**
     * 下面代码添加虚拟节点是为了方便操作，当然不添加虚拟节点也是可以的
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        //边界条件判断
        if (head == null)
            return head;
        //如果要删除的是头结点，直接返回头结点的下一个结点即可
        if (head.val == val)
            return head.next;
        ListNode cur = head;
        //找到要删除结点的上一个结点
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        //删除结点
        cur.next = cur.next.next;
        return head;
    }


    /**
     * 题中说了链表中的节点值互不相同，也就是说最多只能删除一个。
     * 最简单的一种方式就是双指针求解，我们使用两个指针一个指向当前的节点，一个指向当前的上一个节点，
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode0(ListNode head, int val) {
        //初始化一个虚拟节点
        ListNode dummy = new ListNode(0);
        //让虚拟节点指向头结点
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.val == val) {
                //如果找到要删除的结点，直接把他删除
                pre.next = cur.next;
                break;
            }
            //如果没找到，pre指针和cur指针都同时往后移一步
            pre = cur;
            cur = cur.next;
        }
        //最后返回虚拟节点的下一个结点即可
        return dummy.next;
    }


}
