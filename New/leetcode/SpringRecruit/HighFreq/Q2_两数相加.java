package leetcode.HighFreq;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/24 19:32
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(-1);
        ListNode p = d;
        int c = 0;
        while(l1 != null && l2 != null) {
            int cur = c + l1.val + l2.val;
            p.next = new ListNode(cur % 10);
            p = p.next;
            c = cur / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int cur = c + l1.val;
            p.next = new ListNode(cur % 10);
            p = p.next;
            c = cur / 10;
            l1 = l1.next;

        }
        while(l2 != null) {
            int cur = c + l2.val;
            p.next = new ListNode(cur % 10);
            p = p.next;
            c = cur / 10;
            l2 = l2.next;

        }
        if(c == 1) {
            p.next = new ListNode(1);
        }
        return d.next;
    }
}
