package leetcode.HighFreq;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/27 22:18
 */
public class Q148_链表排序 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode d = new ListNode(-1, head);
        ListNode p = d;
        ListNode q = d;

        while(q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        ListNode b = p.next;
        p.next = null;

        ListNode c = mergeSort(head);
        b = mergeSort(b);

        ListNode d1 = new ListNode(-1);
        ListNode p1 = d1;
        while(c != null && b != null) {
            if(c.val <= b.val) {
                p1.next = c;
                c = c.next;
            } else {
                p1.next = b;
                b = b.next;
            }
            p1 = p1.next;
        }
        // 因为是链表，这里不用再while了
        if(c != null) {
            p1.next = c;
        }
        if(b != null) {
            p1.next = b;
        }
        return d1.next;
    }
}
