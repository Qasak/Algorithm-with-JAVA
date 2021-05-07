package leetcode.HighFreq;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/27 22:30
 */
public class Q143_重排链表 {
    public void reorderList(ListNode head) {
        // 1 2 3 4 5
        // 5 4 3 2 1

        // 1 2 3 4
        // 4 3 2 1

        // 1 2
        // 5 4 3

        if(head == null || head.next == null) {
            return;
        }
        ListNode p = head;
        ListNode q = head;
        ListNode a = head;
        while(q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        ListNode b = p.next;

        p.next = null;
        b = reverse(b);
        ListNode t;
        boolean flag = true;
        while(a != null && b != null) {
            if(flag) {
                t = a.next;
                a.next = b;
                a = t;
                flag = false;
            } else {
                t = b.next;
                b.next = a;
                b = t;
                flag = true;
            }
        }
    }
    public ListNode reverse(ListNode head) {
        ListNode p = null, c = head, n = head;
        while(c != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
}
