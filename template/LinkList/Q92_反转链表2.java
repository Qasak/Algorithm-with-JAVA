package leetcode.template.LinkList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/5 17:51
 */
public class Q92_反转链表2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode p1 = d;
        ListNode p2 = d;
        for(int i = 0; i < m - 1; i++) {
            p1 = p1.next;
        }
        for(int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        ListNode p3 = p2.next;
        p2.next = null;
        ListNode p4 = p1.next;
        p1.next = reverse(p1.next);
        p4.next = p3;
        return d.next;
    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, next = head;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
