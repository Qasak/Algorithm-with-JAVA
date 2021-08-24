package leetcode.template.LinkList;

import leetcode.easy.ListNode;

import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/22 13:55
 * 两个一组交换链表
 */
public class Q24_SwapPair {
    // 1->2->3->4
    // 2->1->f()
    //
    // t = root.next;
    // root.next = f(cur)
    // cur = root
    //
    // return t
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode t = head.next;
        head.next = swapPairs(t.next);
        t.next = head;
        return t;
    }
    // 迭代
    public ListNode swapPairs1(ListNode head) {
        // d->1->2->3->4->5
        //t->a->b，交换之后的节点关系要变成 t->b->a
        // temp.next = node2
        // node1.next = node2.next
        // node2.next = node1
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode t = d;
        while(t.next != null && t.next.next != null) {
            ListNode a = t.next;
            ListNode b = t.next.next;
            t.next = b;
            a.next = b.next;
            b.next = a;
            t = a;
        }
        return d.next;
    }
    
}
