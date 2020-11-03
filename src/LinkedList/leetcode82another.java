package LinkedList;

public class leetcode82another {
    public ListNode deleteDuplicates(ListNode head) {
        //特殊情况，头节点为null或头节点下一节点为null，直接返回头节点，这时不存在重复节点
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            //如果头节点与，头节点的下一节点值相等，跳过所有相等节点。递归调用函数判断最后一个跳过节点的后一节点。
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            //如果头节点与，头节点的下一节点值不等，递归调用函数判断头节点的后一节点。
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

}
