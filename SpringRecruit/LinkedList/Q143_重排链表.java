package leetcode.SpringRecruit.LinkedList;

import leetcode.easy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/23 16:13
 */
public class Q143_重排链表 {
    // 神奇的递归
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        int n = 0;
        ListNode p1 = head;
        while(p1 != null) {
            n++;
            p1 = p1.next;
        }
        dfs(head, n);
        return;
    }
    public ListNode dfs(ListNode head, int n) {
        if(n == 1) {
            ListNode tail = head.next;
            head.next = null;
            return tail;
        }
        if(n == 2) {
            ListNode tail = head.next.next;
            head.next.next = null;
            return tail;
        }
        ListNode tail = dfs(head.next, n - 2);
        ListNode outTail = tail.next;
        tail.next = head.next;
        head.next = tail;
        return outTail;
    }

    // 先反转，再合并
    public void reorderList1(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        int n = 0;
        ListNode p = head;
        while(p != null) {
            n++;
            p = p.next;
        }
        ListNode m = findMid(head, n);

        ListNode p2 = m.next;
        m.next = null;
        p2 = reverse(p2);
        // printList(head);
        // printList(p2);
        merge(head, p2);

    }
    public void printList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        System.out.println(list);
    }
    public ListNode findMid(ListNode head, int n) {
        int cnt = 0;
        ListNode p = head;
        while(cnt < (n - 1) / 2) {
            cnt++;
            p = p.next;
        }
        return p;
    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, next = head;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 1 2
    // 4 3

    // 1 2 3 4
    // 6 5 4
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode t1, t2;
        while(p2 != null) {
            t1 = p1.next;
            t2 = p2.next;
            p1.next = p2;
            p2.next = t1;
            p1 = t1;
            p2 = t2;
        }
        return head1;
    }
}
