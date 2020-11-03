package LinkedList;
//给定一个链表，判断链表中是否有环。
//思路：快慢指针，快慢指针相同则有环，如果有环每走一步快慢指针距离会减 1，最终重合。
public class leetcode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p = head, q = head;
        boolean flag = false;
        while (p.next != null && q.next != null) {
            p = p.next;
            if (q.next.next != null) {
                q = q.next.next;
            } else {
                break;
            }
            if (p == q) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
