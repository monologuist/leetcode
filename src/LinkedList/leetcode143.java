package LinkedList;
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

//思路：找到中点断开，翻转后面部分，然后合并前后两个链表
public class leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head.next;
        // 找到链表中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //找链表中点：快慢指针
            //快指针一次走两步，慢指针一次走一步，当快指针走到终点的话，慢指针会刚好到中点。
            //如果节点个数是偶数的话，slow 走到的是左端点，利用这一点，我们可以把奇数和偶数的情况合并，不需要分开考虑。

        }
        // 将后一半链表翻转, 用fast记录后一段的头结点
        fast = reverse(slow.next);
        // 将链表切断
        slow.next = null;
        // 合并链表
        mergeLists(head, fast);
    }
    private void mergeLists(ListNode l1, ListNode l2) {
        ListNode head = l1, temp;
        while (l1 != null && l2 != null) {
            temp = l2.next;
            l2.next = l1.next;
            l1.next = l2;
            l2 = temp;
            l1 = l1.next.next;
        }
        // 将未合并完的l2接到l1后面
        if (l2 != null) {
            l1.next = l2;
        }
        l1 = head;
    }
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
}
