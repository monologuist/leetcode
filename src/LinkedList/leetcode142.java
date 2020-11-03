package LinkedList;
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//思路：同上题，他们相遇时，slow指向的节点就是入环节点，画画图列一下就知道
public class leetcode142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) { // 第一次相遇，slow回到head, fast从相遇点下一个节点开始走，
                slow = head;
                fast = fast.next;
                while (fast != slow) { // 第二次相遇的地方就是环的入口
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }
    //坑点
    //
    //指针比较时直接比较对象，不要用值比较，链表中有可能存在重复值情况
    //第一次相交后，快指针需要从下一个节点开始和头指针一起匀速移动
}
