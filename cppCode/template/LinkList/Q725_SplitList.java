package leetcode.template.LinkList;

import leetcode.easy.ListNode;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/8 12:19
 */
public class Q725_SplitList {
    // 1 就硬做
    public ListNode[] splitListToParts(ListNode root, int k) {

        int n = 0;
        ListNode p = root;
        while(p != null) {
            n++;
            p = p.next;
        }
        // if((n & 1) == 1)
        int len = (n + 1) / k;
        // 5 / 3 = 0
        // 10 / 3 = 3
        p = root;
        ListNode q = null;
        ListNode[] ans = new ListNode[k];
        // k > n
        if(k > n) {
            for(int i = 0; i < k; i++) {
                if(p != null) {
                    ans[i] = p;
                    q = p.next;
                    p.next = null;
                    p = q;
                } else {
                    ans[i] = null;
                }
            }
            return ans;
        }

        // len = 3
        // 10 = 4 + 3 + 3
        // 11 = 4 + 4 + 3
        // len = 4
        // 13 = 5 + 4 + 4
        // 14 = 5 + 5 + 4

        int[] t = new int[k];
        for(int i = 0; i < k; i++) {
            t[i] = len;
            n -= len;
        }
        int idx = 0;
        while(n > 0) {
            t[idx++]++;
            n--;
        }
        // System.out.println(Arrays.toString(t));
        ListNode h = p;
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < t[i] - 1; j++) {
                if(p.next == null) {
                    break;
                }
                p = p.next;
            }
            q = p.next;
            p.next = null;


            ans[i] = h;
            h = q;
            p = h;
        }
        return ans;
    }
}
