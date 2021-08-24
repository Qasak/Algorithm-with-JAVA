package leetcode.template.LinkList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/22 15:21
 */
public class Q24O_Reverse {
    // 1->2->3->4
    // 4->3->2->1
    // 下一个节点的next指向自己，返回链表尾节点
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        for(ListNode i = head; i != null;) {
            ListNode t = i.next;
            i.next = pre;
            pre = i;
            i = t;
        }
        return pre;
    }
}
