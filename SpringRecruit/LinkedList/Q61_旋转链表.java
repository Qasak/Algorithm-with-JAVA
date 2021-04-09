package leetcode.SpringRecruit.LinkedList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/27 9:28
 */
public class Q61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        int cnt = 0;
        ListNode d = new ListNode(-1, head);
        ListNode p = head;
        ListNode tail = null;
        while(p != null) {
            if(p.next == null) {
                tail = p;
            }
            cnt++;
            p = p.next;
        }
        tail.next = head;
        int rsft = cnt - (k % cnt);
        ListNode p1 = d;
        for(int i = 0; i < rsft; i++) {
            p1 = p1.next;
        }
        ListNode newHead = p1.next;
        p1.next = null;
        return newHead;
    }
}
