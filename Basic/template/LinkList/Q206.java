package leetcode.template.LinkList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/22 13:00
 */
public class Q206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, nxt = head;
        while(cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
