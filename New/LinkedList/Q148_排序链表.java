package leetcode.SpringRecruit.LinkedList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/23 18:34
 */
public class Q148_排序链表 {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode m = findMid(head);
        ListNode p1 = mergeSort(m.next);
        m.next = null;
        ListNode p2 = mergeSort(head);
        ListNode d = new ListNode(-1);
        ListNode p = d;
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        if(p1 != null) {
            p.next = p1;
        } else {
            p.next = p2;
        }
        return d.next;
    }
    public ListNode findMid(ListNode head) {
        ListNode d = new ListNode(-1);
        d.next = head;
        ListNode p1 = d;
        ListNode p2 = d;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
