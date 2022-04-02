package JZOffer.LinkedList;

/**
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class offer25 {
    /**
     * 思路1：递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if(l1 == null && l2 == null){
            return null;
        }else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    /**
     * 思路2：迭代
     * 解题思路：
     * 根据题目描述， 链表l1,l2是 递增 的，因此容易想到使用双指针l1和l2遍历两链表，根据l1.val和l2.val 的大小关系确定节点添加顺序，两节点指针交替前进，直至遍历完毕。
     * 引入伪头节点： 由于初始状态合并链表中无节点，因此循环第一轮时无法将节点添加到合并链表中。解决方案：初始化一个辅助节点dum 作为合并链表的伪头节点，将各节点添加至dum 之后。
     *
     * 算法流程：
     *
     * 1。初始化： 伪头节点dum ，节点cur 指向dum 。
     * 2。循环合并： 当l1或l2为空时跳出；
     *  1.当l1.val<l2.val时，cur 的后继节点指定为l1,并l1向前走一步；
     *  2.当l1.val≥l2.val时，cur 的后继节点指定为l2,并l2向前走一步；
     *  3.节点cur 向前走一步，即cur=cur.next 。
     * 3。合并剩余尾部： 跳出时有两种情况，即l1为空或l2为空。
     *  1.若l1/=null ： 将l1添加至节点cur 之后；
     *  2.否则： 将l2添加至节点cur 之后。
     * 4。返回值： 合并链表在伪头节点dum 之后，因此返回dum.next 即可。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

}
