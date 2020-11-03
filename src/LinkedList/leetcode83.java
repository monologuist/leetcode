package LinkedList;



//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//思路：递归
//由于输入的列表已排序，因此我们可以通过将结点的值与它之后的结点进行比较来确定它是否为重复结点。
//如果它是重复的，我们更改当前结点的 next 指针，以便它跳过下一个结点并直接指向下一个结点之后的结点。

public class leetcode83 {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            head.next = deleteDuplicates(head.next);
            if(head.val == head.next.val) head = head.next;
            return head;
        }
    }
}
