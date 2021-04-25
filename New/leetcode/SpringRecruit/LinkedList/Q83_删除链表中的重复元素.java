package leetcode.SpringRecruit.LinkedList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/25 10:42
 */
public class Q83_删除链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null) {
            if(p1.val == p2.val) {
                int x = p1.val;
                while(p2 != null && p2.val == x) {
                    p2 = p2.next;
                }
                p1.next = p2;
            }
            if(p2 == null) {
                return head;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        // 1 1 1 1 1 1 1 2 3 4 4
        while(p.next != null) {
            if(p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        // 1 1 1 1 2
        while(p.next != null) {
            if(p.val == p.next.val) {
                ListNode p1 = p.next;
                int x = p1.val;
                while(p1 != null && p1.val == x) {
                    p1 = p1.next;
                }
                p.next = p1;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
