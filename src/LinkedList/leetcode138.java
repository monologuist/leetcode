package LinkedList;
//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。 要求返回这个链表的 深拷贝。
//详解见https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-by-leetcod/
public class leetcode138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node ptr = head;
        // 将原链表每个节点旁边增加一个节点
        while (ptr != null) {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        ptr = head;
        // 将复制链表的random指向对应的位置
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        // 将复制链表的next指向对应的位置
        Node ptrOld = head, ptrNew = head.next, newHead = head.next;
        while (ptrOld != null) {
            ptrOld.next = ptrOld.next.next;
            ptrNew.next = (ptrNew.next != null) ? ptrNew.next.next : null;
            ptrOld = ptrOld.next;
            ptrNew = ptrNew.next;
        }
        return newHead;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}