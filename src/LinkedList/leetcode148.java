package LinkedList;
//在  O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//思路：归并排序（递归法），找中点和合并操作

//分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
//我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
//找到中点 slow 后，执行 slow.next = None 将链表切断。
//递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
//cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。

//合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
//双指针法合并，建立辅助ListNode h 作为头部。
//设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
//返回辅助ListNode h 作为头部的下个节点 h.next。
//时间复杂度 O(l + r)，l, r 分别代表两个链表长度。
//当题目输入的 head == None 时，直接返回None。

//注意点
//快慢指针 判断 fast 及 fast.Next 是否为 null 值
//递归 mergeSort 需要断开中间节点
//递归返回条件为 head 为 null 或者 head.Next 为 null
public class leetcode148 {
    public ListNode sortList(ListNode head) {
        // 递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        // 找到链表中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return mergeLists(left, right);
    }
    private ListNode mergeLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curNode.next = left;
                left = left.next;
            } else {
                curNode.next = right;
                right = right.next;
            }
            curNode = curNode.next;
        }
        curNode.next = (right != null) ? right : left;
        return dummy.next;
    }
}
