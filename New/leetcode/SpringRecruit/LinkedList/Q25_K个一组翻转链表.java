package leetcode.SpringRecruit.LinkedList;

import leetcode.easy.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 14:01
 */
public class Q25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        // 1,2,3,4,5
        // 2,1,4,3,5
        ListNode p1 = head;
        for(int i = 0; i < k - 1; i++) {
            p1 = p1.next;
            if(p1 == null) {
                return head;
            }
        }
        ListNode p2 = p1.next;
        p1.next = null;
        ListNode pre = null, cur = head, next = head;
        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(p2, k);
        return p1;
    }
    // 不足k个也翻转
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null) {
                return head;
            }
            ListNode d = new ListNode(-1);
            d.next = head;
            ListNode p = d.next;
            int cnt = 0;
            for(; cnt < k - 1; cnt++) {
                if(p.next == null) {
                    return reverse(head);
                }
                p = p.next;
            }
            // 下一段的头节点
            ListNode p1 = p.next;
            // 切断
            p.next = null;
            ListNode p2 = d.next;
            d.next = reverse(d.next);
            p2.next = reverseKGroup(p1, k);
            return d.next;
        }
        private ListNode reverse(ListNode head) {
            ListNode i = null, j = head, k = head;
            while(j != null) {
                k = j.next;
                j.next = i;
                i = j;
                j = k;
            }
            return i;
        }
    }
    // 非递归 + 不足k个也要翻转
    class Solution2 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null) {
                return head;
            }
            ListNode d = new ListNode(-1);
            d.next = head;
            ListNode p = d.next;
            int cnt = 1;
            List<ListNode> h = new ArrayList<>();
            List<ListNode> t = new ArrayList<>();
            while(p != null) {
                ListNode l = p;
                boolean flag = false;
                while(p != null) {
                    if(cnt % k == 0) {
                        flag = true;
                        ListNode p1 = p.next;
                        p.next = null;
                        p = p1;
                        cnt++;

                        t.add(l);
                        h.add(reverse(l));
                        break;
                    } else {
                        p = p.next;
                        cnt++;
                    }

                }
                if(!flag) {
                    t.add(null);
                    h.add(l);
                }
            }
            // for(ListNode l : h) {
            //     System.out.println(l.val);
            // }
            // System.out.println();
            // for(ListNode l : t) {
            //     System.out.println(l.val);
            // }
            for(int i = 0; i < h.size() - 1; i++) {
                t.get(i).next = h.get(i + 1);
            }
            return h.get(0);
        }
        private ListNode reverse(ListNode head) {
            ListNode i = null, j = head, k = head;
            while(j != null) {
                k = j.next;
                j.next = i;
                i = j;
                j = k;
            }
            return i;
        }
    }

    // 非递归2
    // 让reverse返回头尾两个节点
    class Solution3 {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode d = new ListNode(-1, head);
            ListNode pre = d;
            while(head != null) {
                ListNode tail = pre;
                for(int i = 0; i < k; i++) {
                    tail = tail.next;
                    if(tail == null) {
                        pre.next = reverse(head);
                        return d.next;
                    }
                }
                ListNode[] tmp = reverse(head, tail);
                head = tmp[0];
                tail = tmp[1];
                pre.next = head;
                pre = tail;
                head = tail.next;
            }
            return d.next;
        }
        private ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head, next = head;
            while(cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
        private ListNode[] reverse(ListNode head, ListNode tail) {
            ListNode prev = tail.next;
            ListNode p = head;
            while (prev != tail) {
                ListNode nex = p.next;
                p.next = prev;
                prev = p;
                p = nex;
            }
            return new ListNode[]{tail, head};
        }
    }


    class Solution4 {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode d = new ListNode(-1, head);
            ListNode pre = d;
            while(head != null) {
                ListNode tail = pre;
                for(int i = 0; i < k; i++) {
                    tail = tail.next;
                    if(tail == null) {
                        // pre.next = reverse(head);
                        return d.next;
                    }
                }
                // 记录要接上的节点
                ListNode next = tail.next;
                // 切断
                tail.next = null;

                reverse(head);
                // head 和 tail 翻转
                ListNode t = head;
                head = tail;
                tail = t;

                // 重新接上
                tail.next = next;
                pre.next = head;

                // 更新pre和head
                pre = tail;
                head = tail.next;
            }
            return d.next;
        }
        private ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head, next = head;
            while(cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
