package leetcode.HighFreq;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/27 13:09
 */
public class Q53_最大子序和 {
    // 分治
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        return f(nums, 0, n - 1);

    }
    public int f(int[] nums, int l, int r) {
        if(l >= r) {
            return nums[l];
        }
        int m = (l + r) >>> 1;
        return Math.max(Math.max(f(nums, l, m), f(nums, m + 1, r)), g(nums, l, r));
    }
    public int g(int[] nums, int l, int r) {
        int m = (l + r) >>> 1;
        int maxL = Integer.MIN_VALUE;
        int maxR = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = m; i >= l; i--) {
            sum += nums[i];
            maxL = Math.max(maxL, sum);
        }
        sum = 0;
        for(int i = m + 1; i <= r; i++) {
            sum += nums[i];
            maxR = Math.max(maxR, sum);
        }
        return maxL + maxR;
    }

    public int maxSubArray1(int[] nums) {
        // 枚举右端点
        // dp[i] : 以i结尾的连续子数组最大值
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public int maxSubArray2(int[] nums) {
        // 枚举右端点
        // f[i] : 以i结尾的连续子数组最大值
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        int f = nums[0];
        int max = f;
        for(int i = 1; i < n; i++) {
            f = Math.max(nums[i], nums[i] + f);
            max = Math.max(max, f);
        }
        return max;
    }
    // 找出子数组
    public int maxSubArray3(int[] nums) {
        // 枚举右端点
        // f[i] : 以i结尾的连续子数组最大值
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        int f = nums[0];
        int max = f;
        int x = 0, y = 0;
        int start = 0;
        for(int i = 1; i < n; i++) {
            if(nums[i] + f > nums[i]) {
                f = nums[i] + f;
            } else {
                start = i;
                f = nums[i];
            }
            if(f > max) {
                max = f;
                x = start;
                y = i;
            }
        }
        int[] sub = new int[y - x + 1];
        for(int i = x; i <= y; i++) {
            sub[i - x] = nums[i];
        }
        System.out.println(Arrays.toString(sub));
        return max;
    }
}
