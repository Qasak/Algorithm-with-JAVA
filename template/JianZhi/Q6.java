package leetcode.JianZhi;

import leetcode.easy.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 17:23
 */
public class Q6 {
    // 1. stack
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stk = new LinkedList<>();
        ListNode t = head;
        int n = 0;
        while(t != null) {
            n++;
            stk.push(t.val);
            t = t.next;
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = stk.pop();
        }
        return ans;
    }
    // 2.递归

}
