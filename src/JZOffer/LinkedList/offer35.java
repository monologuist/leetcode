package JZOffer.LinkedList;

/**
 * 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * 复杂链表的复制<深拷贝>
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * 返回结果为复制后复杂链表的 head
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/lian-biao-de-shen-kao-bei-by-z1m/
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 */
public class offer35 {
    //https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/jian-zhi-offer-35-fu-za-lian-biao-de-fu-zhi-ha-xi-/

    /**
     * 方法二：拼接 + 拆分
     *
     * 考虑构建 原节点 1 -> 新节点 1 -> 原节点 2 -> 新节点 2 -> …… 的拼接链表，
     * 如此便可在访问原节点的 random 指向节点的同时找到新对应新节点的 random 指向节点。
     *
     * 算法流程：
     * 1。复制各节点，构建拼接链表:
     * 设原链表为node1→node2→⋯ ，构建的拼接链表如下所示：node1→node1new→node2→node2new→⋯
     * 2。构建新链表各节点的 random 指向：
     * 当访问原节点 cur 的随机指向节点 cur.random 时，对应新节点 cur.next 的随机指向节点为 cur.random.next 。
     * 3。拆分原 / 新链表：
     * 设置 pre / cur 分别指向原 / 新链表头节点，遍历执行 pre.next = pre.next.next 和 cur.next = cur.next.next 将两链表拆分开。
     * 4。返回新链表的头节点 res 即可。
     *
     * 复杂度分析：
     * 1。时间复杂度O(N) ： 三轮遍历链表，使用O(N) 时间。
     * 2。空间复杂度O(1) ： 节点引用变量使用常数大小的额外空间。
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null){
            return head;
        }
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while (cur != null){
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        //2. 构建各新节点的random指向
        cur = head;
        while (cur != null){
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head,res = head.next;
        while (cur.next != null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }
}

/**
 * Definition for a Node.
 */
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