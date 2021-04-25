package leetcode.SpringRecruit.LinkedList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 14:01
 */
public class Q21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(-1);
        ListNode p = d;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            p.next = l1;
        }
        if(l2 != null) {
            p.next = l2;
        }
        return d.next;
    }
}
