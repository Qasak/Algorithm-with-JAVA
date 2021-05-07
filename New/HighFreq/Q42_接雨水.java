package leetcode.HighFreq;

import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/28 22:52
 */
public class Q42_接雨水 {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) {
            return 0;
        }
        int[] f = new int[n];
        f[0] = height[0];
        for(int i = 1; i < n; i++) {
            f[i] = Math.max(height[i], f[i - 1]);
        }
        int[] g = new int[n];
        g[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            g[i] = Math.max(height[i], g[i + 1]);
        }
        int ans = 0;
        for(int i = 1; i < n - 1; i++) {
            int cur = Math.min(f[i - 1], g[i + 1]) - height[i];
            ans += Math.max(cur, 0);
        }
        return ans;
    }
    // 双指针 终极解法
    public int trap1(int[] height) {
        int n = height.length;
        if(n == 0) {
            return 0;
        }
        int ans = 0;
        int maxL = 0, maxR = 0;
        int l = 0, r = n - 1;
        while(l < r) {
            maxL = Math.max(maxL, height[l]);
            maxR = Math.max(maxR, height[r]);
            if(maxL < maxR) {
                ans += maxL - height[l++];
            } else {
                ans += maxR - height[r--];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>((a, b) -> (b - a));
    }
}
