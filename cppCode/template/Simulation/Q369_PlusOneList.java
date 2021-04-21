package leetcode.template.Simulation;

import leetcode.easy.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/22 23:00
 */
public class Q369_PlusOneList {
    public ListNode plusOne(ListNode head) {
        // 9,9,9
        ListNode l1 = head;
        Deque<Integer> s1 = new LinkedList<>();
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        s1.push(s1.pop() + 1);
        int carry = 0;
        ListNode d = new ListNode(-1);
        while(!s1.isEmpty() || carry > 0) {
            int sum = carry;
            sum += s1.isEmpty() ? 0 : s1.pop();
            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            // head -> 0 -> 7
            // head -> 8 -> 0 -> 7
            ListNode t = d.next;
            d.next = cur;
            cur.next = t;
        }
        return d.next;
    }


    private ListNode reverse(ListNode head) {
        ListNode pre, cur, next;
        pre = null; cur = head; next = head;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 反转后再加
    public ListNode plusOne1(ListNode head) {
        ListNode newHead = reverse(head);
        ListNode p = newHead;
        // 1 2 3
        // 4 2 1
        newHead.val += 1;
        int c = 0;
        while(newHead != null) {
            int sum = c;
            sum += newHead.val;
            newHead.val = sum % 10;
            c = sum / 10;
            newHead = newHead.next;
        }
        // 0 0 9 1
        newHead = reverse(p);
        if(c != 0) {
            ListNode l = new ListNode(1);
            l.next = newHead;
            return l;
        }
        return newHead;
    }
}
