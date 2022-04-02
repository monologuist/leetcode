package JZOffer.LinkedList;

/**
 * 链表中倒数第k个节点
 * 快慢指针，先让快指针走k步，然后两个指针同步走，当快指针走到头时，慢指针就是链表倒数第k个节点。
 *
 * 算法流程：
 * 1.初始化： 前指针 former 、后指针 latter ，双指针都指向头节点 head​ 。
 * 2.构建双指针距离： 前指针 former 先向前走k 步（结束后，双指针 former 和 latter 间相距k 步）。
 * 3.双指针共同移动： 循环中，双指针 former 和 latter 每轮都向前走一步，直至 former 走过链表 尾节点 时跳出（跳出后， latter 与尾节点距离为k−1，即 latter 指向倒数第k 个节点）。
 * 4.返回值： 返回 latter 即可。
 *
 * 时间复杂度O(N) ：N 为链表长度；总体看， former 走了N 步， latter 走了(N−k) 步。
 * 空间复杂度O(1) ： 双指针 former , latter 使用常数大小的额外空间。
 */
public class offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++)
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
