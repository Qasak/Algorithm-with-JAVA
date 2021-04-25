package leetcode.SpringRecruit.LinkedList;

import leetcode.easy.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/25 11:22
 */
public class Q23_合并K个升序链表 {
    // 0.暴力
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        // ListNode d = new ListNode(-1);
        int n = lists.length;
        ListNode l1 = null;
        int i = 0;
        for(; i < n; i++) {
            if(lists[i] != null) {
                l1 = lists[i];
                break;
            }
        }
        if(l1 == null) {
            return l1;
        }
        for(int j = i + 1; j < n; j++) {
            l1 = mergeTwoLists(l1, lists[j]);
        }
        return l1;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
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
        } else {
            p.next = l2;
        }
        return d.next;
    }
    // 1. 优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        ListNode d = new ListNode(-1);
        ListNode p = d;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(ListNode n : lists) {
            if(n != null) {
                pq.offer(n);
            }
        }
        while(!pq.isEmpty()) {
            ListNode n = pq.poll();
            p.next = n;
            p = p.next;
            if(n.next != null) {
                n = n.next;
                pq.offer(n);
            }
        }
        return d.next;
    }

    // 2.归并

    public static void print(int[] a) {
        System.out.println(a.length);
    }
    public static void main(String[] args) {
        print(null);
    }
}
