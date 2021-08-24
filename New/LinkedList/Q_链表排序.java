package leetcode.template.LinkList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/24 15:58
 */
public class Q_链表排序 {
    // 遍历找中点
//    public ListNode sortList(ListNode head) {
//        return mergeSort(head);
//    }
//    ListNode mergeSort(ListNode head) {
//        if(head == null || head.next == null) {
//            return head;
//        }
//        int n = 0;
//        ListNode p = head;
//        while(p != null) {
//            p = p.next;
//            n++;
//        }
//        // System.out.println(n);
//        int m = n / 2;
//        p = head;
//        while(--m > 0) {
//            p = p.next;
//        }
//        ListNode q = p.next;
//        p.next = null;
//        ListNode l = mergeSort(head);
//        ListNode r = mergeSort(q);
//        ListNode d = new ListNode(-1);
//        ListNode dummy = d;
//        while(l != null && r != null) {
//            if(l.val < r.val) {
//                d.next = l;
//                l = l.next;
//                d = d.next;
//            } else {
//                d.next = r;
//                r = r.next;
//                d = d.next;
//            }
//        }
//        while(l != null) {
//            d.next = l;
//            l = l.next;
//            d = d.next;
//        }
//        while(r != null) {
//            d.next = r;
//            r = r.next;
//            d = d.next;
//        }
//        return dummy.next;
//    }
    // 快慢指针找中点
    public ListNode sortList1(ListNode head) {
        return mergeSort(head);
    }
    ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        // 快慢指针找中点
        ListNode dd = new ListNode(-1);
        dd.next = head;
        ListNode fast = dd, slow = dd;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode q = slow.next;
        slow.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(q);
        ListNode d = new ListNode(-1);
        ListNode dummy = d;
        while(l != null && r != null) {
            if(l.val < r.val) {
                d.next = l;
                l = l.next;
                d = d.next;
            } else {
                d.next = r;
                r = r.next;
                d = d.next;
            }
        }
        while(l != null) {
            d.next = l;
            l = l.next;
            d = d.next;
        }
        while(r != null) {
            d.next = r;
            r = r.next;
            d = d.next;
        }
        return dummy.next;
    }

}
