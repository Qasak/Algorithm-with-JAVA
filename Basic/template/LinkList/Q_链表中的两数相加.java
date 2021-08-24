package leetcode.template.LinkList;

import leetcode.easy.ListNode;

import java.util.Random;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/24 14:55
 */
public class Q_链表中的两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);
        int c = 0;
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while(l1 != null && l2 != null) {
            int cur = l1.val + l2.val + c;
            p.next = new ListNode(cur % 10);
            c = cur / 10;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int cur = l1.val + c;
            p.next = new ListNode(cur % 10);
            c = cur / 10;
            p = p.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            int cur = l2.val + c;
            p.next = new ListNode(cur % 10);
            c = cur / 10;
            p = p.next;
            l2 = l2.next;
        }
        if(c != 0) {
            p.next = new ListNode(1);
        }
        return reverse(head.next);
    }
    ListNode reverse(ListNode p) {
        // System.out.println(p.val);
        // printLink(p);
        ListNode pre, cur, next;
        pre = null; cur = p; next = p;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // printLink(pre);
        return pre;
    }

    // 不反转 栈+头插法
    public static void main(String[] args) {
        Random rand = new Random();
        rand.nextInt(5);

    }
}
