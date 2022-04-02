package JZOffer.LinkedList;

/**
 * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * 两个链表的第一个公共节点
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class offer52 {
    /**
     * 解题思路：
     *
     * 我们使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，
     * 然后同时分别逐结点遍历，当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；
     * 当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
     * 这样，当它们相遇时，所指向的结点就是第一个公共结点。
     *
     * 复杂度分析
     * - 时间复杂度：O(M+N)。
     * - 空间复杂度：O(1)。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {
            /**
             *  两个链表长度分别为L1+C、L2+C， C为公共部分的长度
             *  第一个人走了L1+C步后，回到第二个人起点走L2步；
             *  第2个人走了L2+C步后，回到第一个人起点走L1步。
             *  当两个人走的步数都为L1+L2+C时就两个家伙就相爱了
             */
            /**
             * A：布尔表达式(真/假)，B：执行语句 ，C ：执行语句
             * 最直观的： A ？ B ：C (如果A为真执行B否则执行C)
             */
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }
}
