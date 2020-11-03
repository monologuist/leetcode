package LinkedList;
//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现的数字。
//思路：链表头结点可能被删除，所以用 dummy node 辅助删除
//注意点
// • A->B->C 删除 B，A.next = C
// • 删除用一个 Dummy Node 节点辅助（允许头节点可变）
// • 访问 b.next一定要保证 X != null
public class leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;
        while(b!=null && b.next!=null) {
            //初始化的时a指向的是哑结点，所以比较逻辑应该是a的下一个节点和b的下一个节点
            if(a.next.val!=b.next.val) {
                a = a.next;
                b = b.next;
            }
            else {
                //如果a、b指向的节点值相等，就不断移动b，直到a、b指向的值不相等
                while(b!=null && b.next!=null && a.next.val==b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }
        }
        return dummy.next;
    }

}
