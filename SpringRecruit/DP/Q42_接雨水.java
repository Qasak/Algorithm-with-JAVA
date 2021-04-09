package leetcode.SpringRecruit.DP;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 13:58
 */
public class Q42_接雨水 {
    // 双指针trick
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) {
            return 0;
        }
        int ans = 0;
        int l = 0, r = n - 1;
        int lh = height[l], rh = height[r];
        while(l <= r) {
            if(lh <= rh) {
                lh = Math.max(lh, height[l]);
                ans += lh - height[l++];
            } else {
                rh = Math.max(rh, height[r]);
                ans += rh - height[r--];
            }
        }
        return ans;
    }

    // DP
    public int trap1(int[] height) {
        int n = height.length;
        if(n == 0) {
            return 0;
        }
        int[] L = new int[n];
        int[] R = new int[n];
        int ans = 0;
        L[0] = height[0];
        R[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++) {
            L[i] = Math.max(L[i - 1], height[i]);
        }
        for(int i = n - 2; i >= 0; i--) {
            R[i] = Math.max(R[i + 1], height[i]);
        }
        for(int i = 0; i < n; i++) {
            ans += Math.min(L[i], R[i]) - height[i];
        }
        return ans;
    }
    // 单调栈

    public int trap2(int[] height) {
        int n = height.length;
        if(n == 0) {
            return 0;
        }
        int ans = 0;
        Deque<Integer> stk = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            while(!stk.isEmpty() && height[i] > height[stk.peek()]) {
                int h = height[stk.pop()];
                if(stk.isEmpty()) {
                    break;
                }
                ans += (Math.min(height[stk.peek()], height[i]) - h) * (i - stk.peek() - 1);
            }
            stk.push(i);
        }
        return ans;
    }
}
