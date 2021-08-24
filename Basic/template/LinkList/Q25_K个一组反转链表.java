package leetcode.template.LinkList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/24 14:53
 */
public class Q25_K个一组反转链表 {
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
    class Solution {
        // 切断法
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode p = head;
            int t = k - 1;
            // 不满k个继续反转
            while(t-- > 0 && p.next != null) {
                p = p.next;
            }
            // 不满k个不反转
//            while(t-- > 0 ) {
//                p = p.next;
//                if(p == null) {
//                    return head;
//                }
//            }
            if(p.next == null) {
                return head;
            }
            ListNode q = p.next;
            p.next = null;
            ListNode newHead = reverse(head);
            head.next = reverseKGroup(q, k);
            return newHead;
        }
        ListNode reverse(ListNode p) {
            // System.out.println(p.val);
            // printLink(p);
            ListNode pre, cur, next;
            pre = null; cur = p; next = p;
            while(cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            // printLink(pre);
            return pre;
        }
        void printLink(ListNode p) {
            while(p != null) {
                System.out.print(p.val + " ");
                p = p.next;
            }
            System.out.println();
        }
    }
}
