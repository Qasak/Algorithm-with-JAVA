package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/15 10:57
 */
public class Q213_打家劫舍2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        // 偷当前
        int[] a = new int[n];
        // 不偷当前
        int[] b = new int[n];


        // 1. 偷第一家
        a[0] = nums[0];

        for(int i = 1; i < n - 1; i++) {
            a[i] = b[i - 1] + nums[i];
            b[i] = Math.max(a[i - 1], b[i - 1]);
        }

        int ans1 = Math.max(a[n - 2], b[n - 2]);
        a = new int[n];
        b = new int[n];
        // 2. 不偷第一家
        a[0] = 0;
        for(int i = 1; i < n; i++) {
            a[i] = b[i - 1] + nums[i];
            b[i] = Math.max(a[i - 1], b[i - 1]);
        }
        int ans2 = Math.max(a[n - 1], b[n - 1]);
        return Math.max(ans1, ans2);
    }
    // 空间优化
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if(n == 1) {
                return nums[0];
            }
            // 1. 偷第一家

            // 偷当前
            int a = nums[0];
            // 不偷当前
            int b = 0;

            for(int i = 1; i < n - 1; i++) {
                int aa = a;
                a = b + nums[i];
                b = Math.max(aa, b);
            }

            int ans1 = Math.max(a, b);
            a = 0;
            b = 0;
            // 2. 不偷第一家
            for(int i = 1; i < n; i++) {
                int aa = a;
                a = b + nums[i];
                b = Math.max(aa, b);
            }
            int ans2 = Math.max(a, b);
            return Math.max(ans1, ans2);
        }
    }
}
