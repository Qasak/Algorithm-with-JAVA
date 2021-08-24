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


    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if(head == null) {
            return head;
        }
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode p0 = d;
        ListNode p1 = head;
        for(int i = 0; i < m - 1; i++) {
            p0 = p0.next;
            p1 = p1.next;
        }
        ListNode p2 = p1;
        for(int i = 0; i < n - m; i++) {
            p2 = p2.next;
        }
        ListNode p3 = p2.next;
        p2.next = null;
        ListNode pre = null, cur = p1, next = p1;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next = pre;
        p1.next = p3;
        return d.next;
    }

    // 一趟遍历
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode p = d;
        ListNode pre = d.next;
        for(int i = 0; i < m - 1; i++) {
            p = p.next;
            pre = pre.next;
        }
        ListNode cur = pre.next, next = pre.next;
        for(int i = 0; i < n - m; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p.next.next = next;
        p.next = pre;
        return d.next;
    }
}
