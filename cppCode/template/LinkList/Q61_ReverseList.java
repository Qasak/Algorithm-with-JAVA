package leetcode.template.LinkList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/8 11:40
 */
public class Q61_ReverseList {
    // 1.暴力翻转
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode p = head;
        while(p != null) {
            n++;
            p = p.next;
        }
        k %= n;
        if(k == 0) {
            return head;
        }
        // ListNode d = new ListNode(-1);
        // 1 2 3 4 5

        // 4 5 | 1 2 3
        // 5 4 3 2 1
        ListNode d = reverse(head);
        // 5
        p = d;
        for(int i = 0; i < k - 1; i++) {
            p = p.next;
        }
        ListNode q;
        q = p.next;
        // // 5 4 | 3 2 1
        p.next = null;
        ListNode newHead = reverse(d);
        ListNode newHead2 = reverse(q);
        d.next = newHead2;
        return newHead;

    }
    private ListNode reverse(ListNode head) {
        int cnt = 0;
        ListNode pre = null, cur = head, nxt = head;
        while(cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
    // 2 双指针
    public ListNode rotateRight1(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode p = head;
        while(p != null) {
            n++;
            p = p.next;
        }
        k %= n;
        if(k == 0) {
            return head;
        }
        // ListNode d = new ListNode(-1);
        // 1 2 3 4 5

        // 4 5 | 1 2 3
        // 5 4 3 2 1
        p = head;
        ListNode q = head;
        for(int i = 0; i < k; i++) {
            p = p.next;
        }
        while(p.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode newHead = q.next;
        q.next = null;
        p.next = head;
        return newHead;

    }
}
