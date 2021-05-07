package leetcode.HighFreq;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/26 23:45
 */
public class Q19_删除链表的倒数第k个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode d = new ListNode(-1, head);
        ListNode a = d;
        ListNode b = d;
        for(int i = 0; i < n; i++) {
            b = b.next;
        }
        while(b.next != null) {
            a = a.next;
            b = b.next;
        }
        a.next = a.next.next;

        return d.next;
    }
}
