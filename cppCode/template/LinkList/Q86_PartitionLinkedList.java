package leetcode.template.LinkList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/3 0:32
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class Q86_PartitionLinkedList {
    public ListNode partition(ListNode head, int x) {
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        ListNode n1 = d1;
        ListNode n2 = d2;
        while(head != null) {
            if(head.val < x) {
                n1.next = head;
                head = head.next;
                n1 = n1.next;
                n1.next = null;
            } else {
                n2.next = head;
                head = head.next;
                n2 = n2.next;
                n2.next = null;
            }
        }
        n1.next = d2.next;
        return d1.next;
    }
}
