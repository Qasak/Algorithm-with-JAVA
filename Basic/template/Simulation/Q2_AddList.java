package leetcode.template.Simulation;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/22 10:28
 */
public class Q2_AddList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode d = new ListNode(-1);
        ListNode p = d;
        int a = 0;
        while(p1 != null && p2 != null) {
            int sum = p1.val + p2.val + a;
            p.next = new ListNode(sum % 10);
            p = p.next;
            a = sum / 10;
            p1 = p1.next;
            p2 = p2.next;
        }
        while(p1 != null) {
            int sum = p1.val + a;
            p.next = new ListNode(sum % 10);
            p = p.next;
            a = sum / 10;
            p1 = p1.next;

        }
        while(p2 != null) {
            int sum = p2.val + a;
            p.next = new ListNode(sum % 10);
            p = p.next;
            a = sum / 10;
            p2 = p2.next;
        }
        if(a > 0) {
            p.next = new ListNode(a);
        }
        return d.next;
    }


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode d = new ListNode(-1);
        ListNode p = d;
        int a = 0;
        for(; p1 != null && p2 != null; p = p.next, p1 = p1.next, p2 = p2.next) {
            int sum = p1.val + p2.val + a;
            p.next = new ListNode(sum % 10);
            a = sum / 10;
        }
        for(; p1 != null; p = p.next, p1 = p1.next) {
            int sum = p1.val + a;
            p.next = new ListNode(sum % 10);
            a = sum / 10;
        }
        for(; p2 != null; p = p.next, p2 = p2.next) {
            int sum = p2.val + a;
            p.next = new ListNode(sum % 10);
            a = sum / 10;
        }
        if(a > 0) {
            p.next = new ListNode(a);
        }
        return d.next;
    }
}
