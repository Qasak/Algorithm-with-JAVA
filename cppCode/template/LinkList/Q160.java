package leetcode.template.LinkList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/2 17:22
 */
public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int n = 0;
        int m = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != null) {
            n++;
            p1 = p1.next;
        }
        while(p2 != null) {
            m++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        if(n > m) {
            for(int i = 0; i < n - m; i++) {
                p1 = p1.next;
            }
        } else {
            for(int i = 0; i < m - n; i++) {
                p2 = p2.next;
            }
        }
        while(p1 != p2 && p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
