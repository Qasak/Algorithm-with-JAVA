package leetcode.SpringRecruit.LinkedList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 14:01
 */
public class Q25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        // 1,2,3,4,5
        // 2,1,4,3,5
        ListNode p1 = head;
        for(int i = 0; i < k - 1; i++) {
            p1 = p1.next;
            if(p1 == null) {
                return head;
            }
        }
        ListNode p2 = p1.next;
        p1.next = null;
        ListNode pre = null, cur = head, next = head;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(p2, k);
        return p1;
    }
}
