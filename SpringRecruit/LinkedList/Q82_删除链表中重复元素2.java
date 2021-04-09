package leetcode.SpringRecruit.LinkedList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/25 10:03
 */
public class Q82_删除链表中重复元素2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode d = new ListNode(-1);
            d.next = head;
            ListNode p1 = d;
            ListNode p2 = d.next;
            while((p1 != null) && (p2 != null) && (p2.next == null || p2.val != p2.next.val)) {
                p2 = p2.next;
                p1 = p1.next;
            }
            while(p2 != null && p2.next != null && p2.val == p2.next.val) {
                p2 = p2.next;
            }
            if(p2 == null) {
                return d.next;
            }
            p1.next = deleteDuplicates(p2.next);
            return d.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode d = new ListNode(-1, head);
        ListNode p1 = d;
        while(p1.next != null && p1.next.next != null) {
            if(p1.next.val == p1.next.next.val) {
                ListNode p2 = p1.next;
                int x = p2.val;
                while(p2 != null && p2.val == x) {
                    p2 = p2.next;
                }
                p1.next = p2;
            } else {
                p1 = p1.next;
            }
        }
        return d.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode d = new ListNode(-1, head);
        ListNode p = d;
        if(head == null || head.next == null) {
            return head;
        }
        while(p.next != null && p.next.next != null) {
            if(p.next.val == p.next.next.val) {
                int x = p.next.val;
                ListNode p1 = p.next;
                while(p1 != null && p1.val == x) {
                    p1 = p1.next;
                }
                p.next = p1;
            } else {
                p = p.next;
            }
        }
        return d.next;
    }
}
