package leetcode.template.Simulation;

import leetcode.easy.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/22 12:00
 */
public class Q445_AddListII {
    // 使用反转链表，转化为 Q2
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode d = new ListNode(-1);
        ListNode p = d;
        int a = 0;
        for(; p1 != null && p2 != null; p = p.next, p1 = p1.next, p2 = p2.next) {
            int sum = p1.val + p2.val + a;
            p.next = new ListNode(sum % 10);
            a = sum / 10;
        }
        for(; p1 != null; p = p.next, p1 = p1.next) {
            int sum = p1.val + a;
            p.next = new ListNode(sum % 10);
            a = sum / 10;
        }
        for(; p2 != null; p = p.next, p2 = p2.next) {
            int sum = p2.val + a;
            p.next = new ListNode(sum % 10);
            a = sum / 10;
        }
        if(a > 0) {
            p.next = new ListNode(a);
        }
        return d.next;
    }
    private ListNode reverse(ListNode l) {
        ListNode pre, cur, next;
        pre = null; cur = next = l;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1 7 2 4 3
        //     5 6 4
        // 1 7 8 0 7
        return reverse(addTwoNumbers1(reverse(l1), reverse(l2)));
    }

    // 不使用反转链表
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1.val == 0) {
            return l2;
        }
        if(l2.val == 0) {
            return l1;
        }
        int n = 0, m = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null) {
            n++;
            p1 = p1.next;
        }
        while(p2 != null) {
            m++;
            p2 = p2.next;
        }
        p1 = l1;
        p2 = l2;
        ListNode d = new ListNode(-1);
        ListNode p = d;
        p.next = dfs(p1, p2, n, m);
        if(p.next.val >= 10) {
            ListNode t = p.next;
            t.val %= 10;
            p.next = new ListNode(1);
            p.next.next = t;
        }
        return d.next;
    }
    private ListNode dfs(ListNode l1, ListNode l2, int n, int m) {
        if(l1.next == null && l2.next == null) {
            return new ListNode(l1.val + l2.val);
        }
        int t = 0;
        ListNode cur = null;
        if(n > m) {
            ListNode next = dfs(l1.next, l2, n - 1, m);
            t = next.val / 10;
            cur = new ListNode(l1.val + t);
            next.val = next.val % 10;
            cur.next = next;
        } else if(n < m) {
            ListNode next = dfs(l1, l2.next, n, m - 1);
            t = next.val / 10;
            cur = new ListNode(l2.val + t);
            next.val = next.val % 10;
            cur.next = next;
        } else {
            ListNode next = dfs(l1.next, l2.next, n - 1, m - 1);
            t = next.val / 10;
            cur = new ListNode(l1.val + l2.val + t);
            next.val = next.val % 10;
            cur.next = next;
        }
        return cur;
    }
    // 3: 栈

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        // 7,2,4,3
        //   5,6,4
        // 7,8,0,7
        if(l1.val == 0) {
            return l2;
        }
        if(l2.val == 0) {
            return l1;
        }
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = new ListNode(-1);
        while(!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += s1.isEmpty() ? 0 : s1.pop();
            sum += s2.isEmpty() ? 0 : s2.pop();
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            // head -> 0 -> 7
            // head -> 8 -> 0 -> 7
            ListNode t = head.next;
            head.next = cur;
            cur.next = t;
        }
        return head.next;
    }
    public static void main(String[] args) {
        Deque<Integer> s = new LinkedList<>();

    }
}
