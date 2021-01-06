package leetcode.template.LinkList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/22 14:29
 *
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序
 *
 *
 *给你这个链表：1->2->3->4->5
 *
 * 当k= 2 时，应当返回: 2->1->4->3->5
 *
 * 当k= 3 时，应当返回: 3->2->1->4->5
 *
 *
 */
public class Q25_ReverseKGroup {
    // f(1->2->3)->f(4->5)
    // f(1->2)->f(3->4)->5
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1->2->3->4->5->6
        // 2->1->4->3->6->5
        if(head == null) {
            return head;
        }
        // [l, r)
        ListNode l, r;
        l = r = head;
        for(int i = 0; i < k; i++) {
            if(r == null) {
                return head;
            }
            r = r.next;
        }
        ListNode pre = null;
        for(ListNode i = l; i != r;) {
            ListNode t = i.next;
            i.next = pre;
            pre = i;
            i = t;
        }
        l.next = reverseKGroup(r, k);
        return pre;
    }
}
