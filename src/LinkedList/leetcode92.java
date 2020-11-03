package LinkedList;
//可以参考：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
public class leetcode92 {
    //反转部分单链表的迭代实现
    //迭代的思路大概是：先用一个 for 循环找到第 m 个位置
    //然后再用一个 for 循环将 m 和 n 之间的元素反转 再拼接后续
    public ListNode reverseBetween0(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);  // 哑巴节点，指向链表的头部
        dummy.next = head;
        ListNode pre = dummy;  // pre 指向要翻转子链表的第一个节点
        for (int i = 1; i < m; ++i) {
            pre = pre.next;
        }
        head = pre.next;  // head指向翻转子链表的首部
        ListNode next;
        for (int i = m; i < n; ++i) {
            next = head.next;
            // head节点连接next节点之后链表部分，也就是向后移动一位
            head.next = next.next;
            // next节点移动到需要反转链表部分的首部
            next.next = pre.next;
            // pre继续为需要反转头节点的前驱节点
            pre.next = next;
        }
        return dummy.next;
    }











    //反转部分单链表的递归实现
    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


    //反转单链表的前n个节点
    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }


}
