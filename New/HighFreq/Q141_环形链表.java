package leetcode.HighFreq;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/26 23:04
 */
public class Q141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        // a, b 从同个起点出发，设a的移动速度小于b
        // 不失一般性，设a的速度为1，b的速度为2，那么
        // 如果路径存在环，那么总存在一个位置使得 a == b
        ListNode a = head, b = head;
        // b 一次跑三格也行
        // while(a != null && a.next != null && b != null && b.next != null && b.next.next != null) {
        while(a != null && b != null && b.next != null && b.next.next != null) {
            a = a.next;
            b = b.next.next.next;
            if(a == b) {
                return true;
            }
        }
        return false;
    }
}
