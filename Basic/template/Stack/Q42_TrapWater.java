package leetcode.template.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/19 18:25
 * 接雨水
 *
 *
 */
public class Q42_TrapWater {
    // 每个柱子顶部可以储水的高度为：该柱子的左右两侧最大高度的较小者减去此柱子的高度
    // 遍历每个柱子，累加每个柱子可以储水的高度即可
    // 暴力
    public int trap(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for(int i = 1; i < n - 1; i++) {
            int h = arr[i];
            int lh = h;
            for(int l = i; l >= 0; l--) {
                lh = Math.max(lh, arr[l]);
            }
            int rh = h;
            for(int r = i; r < n; r++) {
                rh = Math.max(rh, arr[r]);
            }
            ans += Math.min(lh, rh) - h;
        }
        return ans;
    }
    // 双指针
    public int trap1(int[] arr) {
        int n = arr.length;
        if(n == 0) {
            return 0;
        }
        int ans = 0;
        int l = 0, r = n - 1;
        int lh = 0, rh = 0;
        while(l <= r) {
            // int h = arr[i];
            // ans += Math.min(lh, rh) - h;

            // [4,2,0,3,2,5]
            if(lh < rh) {
                lh = Math.max(lh, arr[l]);
                ans += lh - arr[l++];
            } else {
                rh = Math.max(rh, arr[r]);
                ans += rh - arr[r--];
            }
        }
        return ans;
    }
    // dp
    // dpl
    // dpr
    public int trap2(int[] arr) {
        int n = arr.length;
        if(n == 0) {
            return 0;
        }
        int ans = 0;
        int[] dpl = new int[n];
        int[] dpr = new int[n];
        dpl[0] = arr[0];
        dpr[n - 1] = arr[n - 1];
        for(int i = 1; i < n - 1; i++) {
            dpl[i] = Math.max(arr[i], dpl[i - 1]);
        }
        for(int i = n - 2; i >= 0 ; i--) {
            dpr[i] = Math.max(arr[i], dpr[i + 1]);
        }
        for(int i = 1; i < n - 1; i++) {
            int h = arr[i];
            int lh = dpl[i];
            int rh = dpr[i];
            ans += Math.min(lh, rh) - h;
        }
        return ans;
    }
    // 单调栈
    public int trap4(int[] h) {
        int n = h.length;
        int ans = 0;
        // 维护一个单减栈
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && h[stack.peek()] < h[i]) {
                // 最低元素的高度
                int height = h[stack.pop()];
                // 没有左边的柱子了
                if(stack.isEmpty()) {
                    break;
                }
                // 高以最低高度为准
                ans += (i - stack.peek() - 1) * (Math.min(h[i] - height, h[stack.peek()]));
            }
            stack.push(i);
        }
        return ans;
    }
    // 递减栈2

    // 6 5 4 3 2 1 999
    // O(2n) = O(n)
    public int trap5(int[] arr) {
        int n = arr.length;
        int ans = 0;
        // 递减栈
        Deque<Integer> s = new LinkedList<>();
        // d = arr[s.pop()]
        // h = min(arr[i], arr[s.peek()]) - d
        // w = arr[i] - s.peek() - 1


        // 0 1 0 2
        // 1 0 2
        //
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && arr[i] > arr[s.peek()]) {
                int d = arr[s.pop()];
                int h = s.isEmpty() ? 0 : Math.min(arr[i], arr[s.peek()]) - d;
                int w = s.isEmpty() ? 0 : i - s.peek() - 1;
                ans += w * h;
            }
            s.push(i);
        }
        return ans;
    }
}
