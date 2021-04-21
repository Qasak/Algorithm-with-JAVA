package leetcode.template.LinkList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/27 21:31
 */
public class Q142 {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        boolean flag = false;
        while(p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            return null;
        }
        p2 = head;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
