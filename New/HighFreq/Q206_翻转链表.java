package leetcode.HighFreq;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/24 22:55
 */
public class Q206_翻转链表 {
    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode a = null, b = head, c = head;
        while(b != null) {
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }
    // 递归
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList1(head.next);
        // head a b c null
        // 把后一个节点的null指向自己
        head.next.next = head;
        head.next = null;
        return p;
    }
}
